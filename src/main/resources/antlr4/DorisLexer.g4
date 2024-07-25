// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// Copied from Apache Spark and modified for Apache Doris

lexer grammar DorisLexer;

@members {
  /**
   * When true, parser should throw ParseExcetion for unclosed bracketed comment.
   */
  public boolean has_unclosed_bracketed_comment = false;

  /**
   * Verify whether current token is a valid decimal token (which contains dot).
   * Returns true if the character that follows the token is not a digit or letter or underscore.
   *
   * For example:
   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is followed
   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
   * which is not a digit or letter or underscore.
   */
  public boolean isValidDecimal() {
    int nextChar = _input.LA(1);
    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
      nextChar == '_') {
      return false;
    } else {
      return true;
    }
  }

  /**
   * This method will be called when we see '/*' and try to match it as a bracketed comment.
   * If the next character is '+', it should be parsed as hint later, and we cannot match
   * it as a bracketed comment.
   *
   * Returns true if the next character is '+'.
   */
  public boolean isHint() {
    int nextChar = _input.LA(1);
    if (nextChar == '+') {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method will be called when the character stream ends and try to find out the
   * unclosed bracketed comment.
   * If the method be called, it means the end of the entire character stream match,
   * and we set the flag and fail later.
   */
  public void markUnclosedComment() {
    has_unclosed_bracketed_comment = true;
  }
}

SEMICOLON: ';';

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
COMMA: ',';
DOT: '.';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';

// TODO: add a doc to list reserved words

//============================
// Start of the keywords list
//============================
//--DORIS-KEYWORD-LIST-START
ACCOUNT_LOCK: [aA][cC][cC][oO][uU][nN][tT]'_'[lL][oO][cC][kK];
ACCOUNT_UNLOCK: [aA][cC][cC][oO][uU][nN][tT]'_'[uU][nN][lL][oO][cC][kK];
ADD: [aA][dD][dD];
ADDDATE: [aA][dD][dD][dD][aA][tT][eE];
ADMIN: [aA][dD][mM][iI][nN];
AFTER: [aA][fF][tT][eE][rR];
AGG_STATE: [aA][gG][gG]'_'[sS][tT][aA][tT][eE];
AGGREGATE: [aA][gG][gG][rR][eE][gG][aA][tT][eE];
ALIAS: [aA][lL][iI][aA][sS];
ALL: [aA][lL][lL];
ALTER: [aA][lL][tT][eE][rR];
ANALYZE: [aA][nN][aA][lL][yY][zZ][eE];
ANALYZED: [aA][nN][aA][lL][yY][zZ][eE][dD];
AND: [aA][nN][dD];
ANTI: [aA][nN][tT][iI];
APPEND: [aA][pP][pP][eE][nN][dD];
ARRAY: [aA][rR][rR][aA][yY];
ARRAY_RANGE: [aA][rR][rR][aA][yY]'_'[rR][aA][nN][gG][eE];
AS: [aA][sS];
ASC: [aA][sS][cC];
AT: [aA][tT];
AUTHORS: [aA][uU][tT][hH][oO][rR][sS];
AUTO: [aA][uU][tT][oO];
AUTO_INCREMENT: [aA][uU][tT][oO]'_'[iI][nN][cC][rR][eE][mM][eE][nN][tT];
ALWAYS: [aA][lL][wW][aA][yY][sS];
BACKEND: [bB][aA][cC][kK][eE][nN][dD];
BACKENDS: [bB][aA][cC][kK][eE][nN][dD][sS];
BACKUP: [bB][aA][cC][kK][uU][pP];
BEGIN: [bB][eE][gG][iI][nN];
BELONG: [bB][eE][lL][oO][nN][gG];
BETWEEN: [bB][eE][tT][wW][eE][eE][nN];
BIGINT: [bB][iI][gG][iI][nN][tT];
BIN: [bB][iI][nN];
BINARY: [bB][iI][nN][aA][rR][yY];
BINLOG: [bB][iI][nN][lL][oO][gG];
BITAND: [bB][iI][tT][aA][nN][dD];
BITMAP: [bB][iI][tT][mM][aA][pP];
BITMAP_UNION: [bB][iI][tT][mM][aA][pP]'_'[uU][nN][iI][oO][nN];
BITOR: [bB][iI][tT][oO][rR];
BITXOR: [bB][iI][tT][xX][oO][rR];
BLOB: [bB][lL][oO][bB];
BOOLEAN: [bB][oO][oO][lL][eE][aA][nN];
BRIEF: [bB][rR][iI][eE][fF];
BROKER: [bB][rR][oO][kK][eE][rR];
BUCKETS: [bB][uU][cC][kK][eE][tT][sS];
BUILD: [bB][uU][iI][lL][dD];
BUILTIN: [bB][uU][iI][lL][tT][iI][nN];
BULK: [bB][uU][lL][kK];
BY: [bB][yY];
CACHE: [cC][aA][cC][hH][eE];
CACHED: [cC][aA][cC][hH][eE][dD];
CALL: [cC][aA][lL][lL];
CANCEL: [cC][aA][nN][cC][eE][lL];
CASE: [cC][aA][sS][eE];
CAST: [cC][aA][sS][tT];
CATALOG: [cC][aA][tT][aA][lL][oO][gG];
CATALOGS: [cC][aA][tT][aA][lL][oO][gG][sS];
CHAIN: [cC][hH][aA][iI][nN];
CHAR: [cC][hH][aA][rR]|[cC][hH][aA][rR][aA][cC][tT][eE][rR];
CHARSET: [cC][hH][aA][rR][sS][eE][tT];
CHECK: [cC][hH][eE][cC][kK];
CLEAN: [cC][lL][eE][aA][nN];
CLUSTER: [cC][lL][uU][sS][tT][eE][rR];
CLUSTERS: [cC][lL][uU][sS][tT][eE][rR][sS];
COLLATE: [cC][oO][lL][lL][aA][tT][eE];
COLLATION: [cC][oO][lL][lL][aA][tT][iI][oO][nN];
COLLECT: [cC][oO][lL][lL][eE][cC][tT];
COLOCATE: [cC][oO][lL][oO][cC][aA][tT][eE];
COLUMN: [cC][oO][lL][uU][mM][nN];
COLUMNS: [cC][oO][lL][uU][mM][nN][sS];
COMMENT: [cC][oO][mM][mM][eE][nN][tT];
COMMIT: [cC][oO][mM][mM][iI][tT];
COMMITTED: [cC][oO][mM][mM][iI][tT][eE][dD];
COMPACT: [cC][oO][mM][pP][aA][cC][tT];
COMPLETE: [cC][oO][mM][pP][lL][eE][tT][eE];
COMPRESS_TYPE: [cC][oO][mM][pP][rR][eE][sS][sS]'_'[tT][yY][pP][eE];
CONFIG: [cC][oO][nN][fF][iI][gG];
CONNECTION: [cC][oO][nN][nN][eE][cC][tT][iI][oO][nN];
CONNECTION_ID: [cC][oO][nN][nN][eE][cC][tT][iI][oO][nN]'_'[iI][dD];
CONSISTENT: [cC][oO][nN][sS][iI][sS][tT][eE][nN][tT];
CONSTRAINT: [cC][oO][nN][sS][tT][rR][aA][iI][nN][tT];
CONSTRAINTS: [cC][oO][nN][sS][tT][rR][aA][iI][nN][tT][sS];
CONVERT: [cC][oO][nN][vV][eE][rR][tT];
CONVERT_LSC: [cC][oO][nN][vV][eE][rR][tT]'_'[lL][sS][cC];
COPY: [cC][oO][pP][yY];
COUNT: [cC][oO][uU][nN][tT];
CREATE: [cC][rR][eE][aA][tT][eE];
CREATION: [cC][rR][eE][aA][tT][iI][oO][nN];
CRON: [cC][rR][oO][nN];
CROSS: [cC][rR][oO][sS][sS];
CUBE: [cC][uU][bB][eE];
CURRENT: [cC][uU][rR][rR][eE][nN][tT];
CURRENT_CATALOG: [cC][uU][rR][rR][eE][nN][tT]'_'[cC][aA][tT][aA][lL][oO][gG];
CURRENT_DATE: [cC][uU][rR][rR][eE][nN][tT]'_'[dD][aA][tT][eE];
CURRENT_TIME: [cC][uU][rR][rR][eE][nN][tT]'_'[tT][iI][mM][eE];
CURRENT_TIMESTAMP: [cC][uU][rR][rR][eE][nN][tT]'_'[tT][iI][mM][eE][sS][tT][aA][mM][pP];
CURRENT_USER: [cC][uU][rR][rR][eE][nN][tT]'_'[uU][sS][eE][rR];
DATA: [dD][aA][tT][aA];
DATABASE: [dD][aA][tT][aA][bB][aA][sS][eE];
DATABASES: [dD][aA][tT][aA][bB][aA][sS][eE][sS];
DATE: [dD][aA][tT][eE];
DATE_ADD: [dD][aA][tT][eE]'_'[aA][dD][dD];
DATE_CEIL: [dD][aA][tT][eE]'_'[cC][eE][iI][lL];
DATE_DIFF: [dD][aA][tT][eE]'_'[dD][iI][fF][fF];
DATE_FLOOR: [dD][aA][tT][eE]'_'[fF][lL][oO][oO][rR];
DATE_SUB: [dD][aA][tT][eE]'_'[sS][uU][bB];
DATEADD: [dD][aA][tT][eE][aA][dD][dD];
DATEDIFF: [dD][aA][tT][eE][dD][iI][fF][fF];
DATETIME: [dD][aA][tT][eE][tT][iI][mM][eE];
DATETIMEV2: [dD][aA][tT][eE][tT][iI][mM][eE][vV][2];
DATEV2: [dD][aA][tT][eE][vV][2];
DATETIMEV1: [dD][aA][tT][eE][tT][iI][mM][eE][vV][1];
DATEV1: [dD][aA][tT][eE][vV][1];
DAY: [dD][aA][yY];
DAYS_ADD: [dD][aA][yY][sS]'_'[aA][dD][dD];
DAYS_SUB: [dD][aA][yY][sS]'_'[sS][uU][bB];
DECIMAL: [dD][eE][cC][iI][mM][aA][lL];
DECIMALV2: [dD][eE][cC][iI][mM][aA][lL][vV][2];
DECIMALV3: [dD][eE][cC][iI][mM][aA][lL][vV][3];
DECOMMISSION: [dD][eE][cC][oO][mM][mM][iI][sS][sS][iI][oO][nN];
DEFAULT: [dD][eE][fF][aA][uU][lL][tT];
DEFERRED: [dD][eE][fF][eE][rR][rR][eE][dD];
DELETE: [dD][eE][lL][eE][tT][eE];
DEMAND: [dD][eE][mM][aA][nN][dD];
DESC: [dD][eE][sS][cC];
DESCRIBE: [dD][eE][sS][cC][rR][iI][bB][eE];
DIAGNOSE: [dD][iI][aA][gG][nN][oO][sS][eE];
DISK: [dD][iI][sS][kK];
DISTINCT: [dD][iI][sS][tT][iI][nN][cC][tT];
DISTINCTPC: [dD][iI][sS][tT][iI][nN][cC][tT][pP][cC];
DISTINCTPCSA: [dD][iI][sS][tT][iI][nN][cC][tT][pP][cC][sS][aA];
DISTRIBUTED: [dD][iI][sS][tT][rR][iI][bB][uU][tT][eE][dD];
DISTRIBUTION: [dD][iI][sS][tT][rR][iI][bB][uU][tT][iI][oO][nN];
DIV: [dD][iI][vV];
DO: [dD][oO];
DORIS_INTERNAL_TABLE_ID: [dD][oO][rR][iI][sS]'_'[iI][nN][tT][eE][rR][nN][aA][lL]'_'[tT][aA][bB][lL][eE]'_'[iI][dD];
DOUBLE: [dD][oO][uU][bB][lL][eE];
DROP: [dD][rR][oO][pP];
DROPP: [dD][rR][oO][pP][pP];
DUAL: [dD][uU][aA][lL];
DUPLICATE: [dD][uU][pP][lL][iI][cC][aA][tT][eE];
DYNAMIC: [dD][yY][nN][aA][mM][iI][cC];
ELSE: [eE][lL][sS][eE];
ENABLE: [eE][nN][aA][bB][lL][eE];
ENCRYPTKEY: [eE][nN][cC][rR][yY][pP][tT][kK][eE][yY];
ENCRYPTKEYS: [eE][nN][cC][rR][yY][pP][tT][kK][eE][yY][sS];
END: [eE][nN][dD];
ENDS: [eE][nN][dD][sS];
ENGINE: [eE][nN][gG][iI][nN][eE];
ENGINES: [eE][nN][gG][iI][nN][eE][sS];
ENTER: [eE][nN][tT][eE][rR];
ERRORS: [eE][rR][rR][oO][rR][sS];
EVENTS: [eE][vV][eE][nN][tT][sS];
EVERY: [eE][vV][eE][rR][yY];
EXCEPT: [eE][xX][cC][eE][pP][tT];
EXCLUDE: [eE][xX][cC][lL][uU][dD][eE];
EXECUTE: [eE][xX][eE][cC][uU][tT][eE];
EXISTS: [eE][xX][iI][sS][tT][sS];
EXPIRED: [eE][xX][pP][iI][rR][eE][dD];
EXPLAIN: [eE][xX][pP][lL][aA][iI][nN];
EXPORT: [eE][xX][pP][oO][rR][tT];
EXTENDED: [eE][xX][tT][eE][nN][dD][eE][dD];
EXTERNAL: [Ee][Xx][Tt][Ee][Rr][Nn][Aa][Ll];
EXTRACT: [Ee][Xx][Tt][Rr][Aa][Cc][Tt];
FAILED_LOGIN_ATTEMPTS: [Ff][Aa][Ii][Ll][Ee][Dd]'_'[Ll][Oo][Gg][Ii][Nn]'_'[Aa][Tt][Tt][Ee][Mm][Pp][Tt][Ss];
FALSE: [Ff][Aa][Ll][Ss][Ee];
FAST: [Ff][Aa][Ss][Tt];
FEATURE: [Ff][Ee][Aa][Tt][Uu][Rr][Ee];
FIELDS: [Ff][Ii][Ee][Ll][Dd][Ss];
FILE: [Ff][Ii][Ll][Ee];
FILTER: [Ff][Ii][Ll][Tt][Ee][Rr];
FIRST: [Ff][Ii][Rr][Ss][Tt];
FLOAT: [Ff][Ll][Oo][Aa][Tt];
FOLLOWER: [Ff][Oo][Ll][Ll][Oo][Ww][Ee][Rr];
FOLLOWING: [Ff][Oo][Ll][Ll][Oo][Ww][Ii][Nn][Gg];
FOR: [Ff][Oo][Rr];
FOREIGN: [Ff][Oo][Rr][Ee][Ii][Gg][Nn];
FORCE: [Ff][Oo][Rr][Cc][Ee];
FORMAT: [Ff][Oo][Rr][Mm][Aa][Tt];
FREE: [Ff][Rr][Ee][Ee];
FROM: [Ff][Rr][Oo][Mm];
FRONTEND: [Ff][Rr][Oo][Nn][Tt][Ee][Nn][Dd];
FRONTENDS: [Ff][Rr][Oo][Nn][Tt][Ee][Nn][Dd][Ss];
FULL: [Ff][Uu][Ll][Ll];
FUNCTION: [Ff][Uu][Nn][Cc][Tt][Ii][Oo][Nn];
FUNCTIONS: [Ff][Uu][Nn][Cc][Tt][Ii][Oo][Nn][Ss];
GENERATED: [Gg][Ee][Nn][Ee][Rr][Aa][Tt][Ee][Dd];
GENERIC: [Gg][Ee][Nn][Ee][Rr][Ii][Cc];
GLOBAL: [Gg][Ll][Oo][Bb][Aa][Ll];
GRANT: [Gg][Rr][Aa][Nn][Tt];
GRANTS: [Gg][Rr][Aa][Nn][Tt][Ss];
GRAPH: [Gg][Rr][Aa][Pp][Hh];
GROUP: [Gg][Rr][Oo][Uu][Pp];
GROUPING: [Gg][Rr][Oo][Uu][Pp][Ii][Nn][Gg];
GROUPS: [Gg][Rr][Oo][Uu][Pp][Ss];
HASH: [Hh][Aa][Ss][Hh];
HAVING: [Hh][Aa][Vv][Ii][Nn][Gg];
HDFS: [Hh][Dd][Ff][Ss];
HELP: [Hh][Ee][Ll][Pp];
HISTOGRAM: [Hh][Ii][Ss][Tt][Oo][Gg][Rr][Aa][Mm];
HLL: [Hh][Ll][Ll];
HLL_UNION: [Hh][Ll][Ll]'_'[Uu][Nn][Ii][Oo][Nn];
HOSTNAME: [Hh][Oo][Ss][Tt][Nn][Aa][Mm][Ee];
HOTSPOT: [Hh][Oo][Tt][Ss][Pp][Oo][Tt];
HOUR: [Hh][Oo][Uu][Rr];
HUB: [Hh][Uu][Bb];
IDENTIFIED: [Ii][Dd][Ee][Nn][Tt][Ii][Ff][Ii][Ee][Dd];
IF: [Ii][Ff];
IGNORE: [Ii][Gg][Nn][Oo][Rr][Ee];
IMMEDIATE: [Ii][Mm][Mm][Ee][Dd][Ii][Aa][Tt][Ee];
IN: [Ii][Nn];
INCREMENTAL: [Ii][Nn][Cc][Rr][Ee][Mm][Ee][Nn][Tt][Aa][Ll];
INDEX: [Ii][Nn][Dd][Ee][Xx];
INDEXES: [Ii][Nn][Dd][Ee][Xx][Ee][Ss];
INFILE: [Ii][Nn][Ff][Ii][Ll][Ee];
INNER: [Ii][Nn][Nn][Ee][Rr];
INSERT: [Ii][Nn][Ss][Ee][Rr][Tt];
INSTALL: [Ii][Nn][Ss][Tt][Aa][Ll][Ll];
INT: [Ii][Nn][Tt];
INTEGER: [Ii][Nn][Tt][Ee][Gg][Ee][Rr];
INTERMEDIATE: [Ii][Nn][Tt][Ee][Rr][Mm][Ee][Dd][Ii][Aa][Tt][Ee];
INTERSECT: [Ii][Nn][Tt][Ee][Rr][Ss][Ee][Cc][Tt];
INTERVAL: [Ii][Nn][Tt][Ee][Rr][Vv][Aa][Ll];
INTO: [Ii][Nn][Tt][Oo];
INVERTED: [Ii][Nn][Vv][Ee][Rr][Tt][Ee][Dd];
IPV4: [Ii][Pp][Vv]'4';
IPV6: [Ii][Pp][Vv]'6';
IS: [Ii][Ss];
IS_NOT_NULL_PRED: [Ii][Ss]'_'[Nn][Oo][Tt]'_'[Nn][Uu][Ll][Ll]'_'[Pp][Rr][Ee][Dd];
IS_NULL_PRED: [Ii][Ss]'_'[Nn][Uu][Ll][Ll]'_'[Pp][Rr][Ee][Dd];
ISNULL: [Ii][Ss][Nn][Uu][Ll][Ll];
ISOLATION: [Ii][Ss][Oo][Ll][Aa][Tt][Ii][Oo][Nn];
JOB: [Jj][Oo][Bb];
JOBS: [Jj][Oo][Bb][Ss];
JOIN: [Jj][Oo][Ii][Nn];
JSON: [Jj][Ss][Oo][Nn];
JSONB: [Jj][Ss][Oo][Nn][Bb];
KEY: [Kk][Ee][Yy];
KEYS: [Kk][Ee][Yy][Ss];
KILL: [Kk][Ii][Ll][Ll];
LABEL: [Ll][Aa][Bb][Ee][Ll];
LARGEINT: [Ll][Aa][Rr][Gg][Ee][Ii][Nn][Tt];
LAST: [Ll][Aa][Ss][Tt];
LATERAL: [Ll][Aa][Tt][Ee][Rr][Aa][Ll];
LDAP: [Ll][Dd][Aa][Pp];
LDAP_ADMIN_PASSWORD: [Ll][Dd][Aa][Pp]'_'[Aa][Dd][Mm][Ii][Nn]'_'[Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd];
LEFT: [Ll][Ee][Ff][Tt];
LESS: [Ll][Ee][Ss][Ss];
LEVEL: [Ll][Ee][Vv][Ee][Ll];
LIKE: [Ll][Ii][Kk][Ee];
LIMIT: [Ll][Ii][Mm][Ii][Tt];
LINES: [Ll][Ii][Nn][Ee][Ss];
LINK: [Ll][Ii][Nn][Kk];
LIST: [Ll][Ii][Ss][Tt];
LOAD: [Ll][Oo][Aa][Dd];
LOCAL: [Ll][Oo][Cc][Aa][Ll];
LOCALTIME: [Ll][Oo][Cc][Aa][Ll][Tt][Ii][Mm][Ee];
LOCALTIMESTAMP: [Ll][Oo][Cc][Aa][Ll][Tt][Ii][Mm][Ee][Ss][Tt][Aa][Mm][Pp];
LOCATION: [Ll][Oo][Cc][Aa][Tt][Ii][Oo][Nn];
LOCK: [Ll][Oo][Cc][Kk];
LOGICAL: [Ll][Oo][Gg][Ii][Cc][Aa][Ll];
LOW_PRIORITY: [Ll][Oo][Ww]'_'[Pp][Rr][Ii][Oo][Rr][Ii][Tt][Yy];
MANUAL: [Mm][Aa][Nn][Uu][Aa][Ll];
MAP: [Mm][Aa][Pp];
MATCH: [Mm][Aa][Tt][Cc][Hh];
MATCH_ALL: [Mm][Aa][Tt][Cc][Hh]'_'[Aa][Ll][Ll];
MATCH_ANY: [Mm][Aa][Tt][Cc][Hh]'_'[Aa][Nn][Yy];
MATCH_PHRASE: [Mm][Aa][Tt][Cc][Hh]'_'[Pp][Hh][Rr][Aa][Ss][Ee];
MATCH_PHRASE_EDGE: [Mm][Aa][Tt][Cc][Hh]'_'[Pp][Hh][Rr][Aa][Ss][Ee]'_'[Ee][Dd][Gg][Ee];
MATCH_PHRASE_PREFIX: [Mm][Aa][Tt][Cc][Hh]'_'[Pp][Hh][Rr][Aa][Ss][Ee]'_'[Pp][Rr][Ee][Ff][Ii][Xx];
MATCH_REGEXP: [Mm][Aa][Tt][Cc][Hh]'_'[Rr][Ee][Gg][Ee][Xx][Pp];
MATERIALIZED: [Mm][Aa][Tt][Ee][Rr][Ii][Aa][Ll][Ii][Zz][Ee][Dd];
MAX: [Mm][Aa][Xx];
MAXVALUE: [Mm][Aa][Xx][Vv][Aa][Ll][Uu][Ee];
MEMO: [Mm][Ee][Mm][Oo];
MERGE: [Mm][Ee][Rr][Gg][Ee];
MIGRATE: [Mm][Ii][Gg][Rr][Aa][Tt][Ee];
MIGRATIONS: [Mm][Ii][Gg][Rr][Aa][Tt][Ii][Oo][Nn][Ss];
MIN: [Mm][Ii][Nn];
MINUS: [Mm][Ii][Nn][Uu][Ss];
MINUTE: [Mm][Ii][Nn][Uu][Tt][Ee];
MODIFY: [Mm][Oo][Dd][Ii][Ff][Yy];
MONTH: [Mm][Oo][Nn][Tt][Hh];
MTMV: [Mm][Tt][Mm][Vv];
NAME: [Nn][Aa][Mm][Ee];
NAMES: [Nn][Aa][Mm][Ee][Ss];
NATURAL: [Nn][Aa][Tt][Uu][Rr][Aa][Ll];
NEGATIVE: [Nn][Ee][Gg][Aa][Tt][Ii][Vv][Ee];
NEVER: [Nn][Ee][Vv][Ee][Rr];
NEXT: [Nn][Ee][Xx][Tt];
NGRAM_BF: [Nn][Gg][Rr][Aa][Mm]'_'[Bb][Ff];
NO: [Nn][Oo];
NON_NULLABLE: [Nn][Oo][Nn]'_'[Nn][Uu][Ll][Ll][Aa][Bb][Ll][Ee];
NOT: [Nn][Oo][Tt];
NULL: [Nn][Uu][Ll][Ll];
NULLS: [Nn][Uu][Ll][Ll][Ss];
OBSERVER: [Oo][Bb][Ss][Ee][Rr][Vv][Ee][Rr];
OF: [Oo][Ff];
OFFSET: [Oo][Ff][Ff][Ss][Ee][Tt];
ON: [Oo][Nn];
ONLY: [Oo][Nn][Ll][Yy];
OPEN: [Oo][Pp][Ee][Nn];
OPTIMIZED: [Oo][Pp][Tt][Ii][Mm][Ii][Zz][Ee][Dd];
OR: [Oo][Rr];
ORDER: [Oo][Rr][Dd][Ee][Rr];
OUTER: [Oo][Uu][Tt][Ee][Rr];
OUTFILE: [Oo][Uu][Tt][Ff][Ii][Ll][Ee];
OVER: [Oo][Vv][Ee][Rr];
OVERWRITE: [Oo][Vv][Ee][Rr][Ww][Rr][Ii][Tt][Ee];
PARAMETER: [Pp][Aa][Rr][Aa][Mm][Ee][Tt][Ee][Rr];
PARSED: [Pp][Aa][Rr][Ss][Ee][Dd];
PARTITION: [Pp][Aa][Rr][Tt][Ii][Tt][Ii][Oo][Nn];
PARTITIONS: [Pp][Aa][Rr][Tt][Ii][Tt][Ii][Oo][Nn][Ss];
PASSWORD: [Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd];
PASSWORD_EXPIRE: [Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]'_'[Ee][Xx][Pp][Ii][Rr][Ee];
PASSWORD_HISTORY: [Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]'_'[Hh][Ii][Ss][Tt][Oo][Rr][Yy];
PASSWORD_LOCK_TIME: [Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]'_'[Ll][Oo][Cc][Kk]'_'[Tt][Ii][Mm][Ee];
PASSWORD_REUSE: [Pp][Aa][Ss][Ss][Ww][Oo][Rr][Dd]'_'[Rr][Ee][Uu][Ss][Ee];
PATH: [Pp][Aa][Tt][Hh];
PAUSE: [Pp][Aa][Uu][Ss][Ee];
PERCENT: [Pp][Ee][Rr][Cc][Ee][Nn][Tt];
PERIOD: [Pp][Ee][Rr][Ii][Oo][Dd];
PERMISSIVE: [Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Vv][Ee];
PHYSICAL: [Pp][Hh][Yy][Ss][Ii][Cc][Aa][Ll];
PI: [Pp][Ii];
PLACEHOLDER: '?';
PLAN: [Pp][Ll][Aa][Nn];
PRIVILEGES: [Pp][Rr][Ii][Vv][Ii][Ll][Ee][Gg][Ee][Ss];
PROCESS: [Pp][Rr][Oo][Cc][Ee][Ss][Ss];
PLUGIN: [Pp][Ll][Uu][Gg][Ii][Nn];
PLUGINS: [Pp][Ll][Uu][Gg][Ii][Nn][Ss];
POLICY: [Pp][Oo][Ll][Ii][Cc][Yy];
PRECEDING: [Pp][Rr][Ee][Cc][Ee][Dd][Ii][Nn][Gg];
PREPARE: [Pp][Rr][Ee][Pp][Aa][Rr][Ee];
PRIMARY: [Pp][Rr][Ii][Mm][Aa][Rr][Yy];
PROC: [Pp][Rr][Oo][Cc];
PROCEDURE: [Pp][Rr][Oo][Cc][Ee][Dd][Uu][Rr][Ee];
PROCESSLIST: [Pp][Rr][Oo][Cc][Ee][Ss][Ss][Ll][Ii][Ss][Tt];
PROFILE: [Pp][Rr][Oo][Ff][Ii][Ll][Ee];
PROPERTIES: [Pp][Rr][Oo][Pp][Ee][Rr][Tt][Ii][Ee][Ss];
PROPERTY: [Pp][Rr][Oo][Pp][Ee][Rr][Tt][Yy];
QUANTILE_STATE: [Qq][Uu][Aa][Nn][Tt][Ii][Ll][Ee]'_'[Ss][Tt][Aa][Tt][Ee];
QUANTILE_UNION: [Qq][Uu][Aa][Nn][Tt][Ii][Ll][Ee]'_'[Uu][Nn][Ii][Oo][Nn];
QUERY: [Qq][Uu][Ee][Rr][Yy];
QUOTA: [Qq][Uu][Oo][Tt][Aa];
RANDOM: [Rr][Aa][Nn][Dd][Oo][Mm];
RANGE: [Rr][Aa][Nn][Gg][Ee];
READ: [Rr][Ee][Aa][Dd];
REAL: [Rr][Ee][Aa][Ll];
REBALANCE: [Rr][Ee][Bb][Aa][Ll][Aa][Nn][Cc][Ee];
RECENT: [Rr][Ee][Cc][Ee][Nn][Tt];
RECOVER: [Rr][Ee][Cc][Oo][Vv][Ee][Rr];
RECYCLE: [Rr][Ee][Cc][Yy][Cc][Ll][Ee];
REFRESH: [Rr][Ee][Ff][Rr][Ee][Ss][Hh];
REFERENCES: [Rr][Ee][Ff][Ee][Rr][Ee][Nn][Cc][Ee][Ss];
REGEXP: [Rr][Ee][Gg][Ee][Xx][Pp];
RELEASE: [Rr][Ee][Ll][Ee][Aa][Ss][Ee];
RENAME: [Rr][Ee][Nn][Aa][Mm][Ee];
REPAIR: [Rr][Ee][Pp][Aa][Ii][Rr];
REPEATABLE: [Rr][Ee][Pp][Ee][Aa][Tt][Aa][Bb][Ll][Ee];
REPLACE: [Rr][Ee][Pp][Ll][Aa][Cc][Ee];
REPLACE_IF_NOT_NULL: [Rr][Ee][Pp][Ll][Aa][Cc][Ee]'_'[Ii][Ff]'_'[Nn][Oo][Tt]'_'[Nn][Uu][Ll][Ll];
REPLICA: [Rr][Ee][Pp][Ll][Ii][Cc][Aa];
REPOSITORIES: [Rr][Ee][Pp][Oo][Ss][Ii][Tt][Oo][Rr][Ii][Ee][Ss];
REPOSITORY: [Rr][Ee][Pp][Oo][Ss][Ii][Tt][Oo][Rr][Yy];
RESOURCE: [Rr][Ee][Ss][Oo][Uu][Rr][Cc][Ee];
RESOURCES: [Rr][Ee][Ss][Oo][Uu][Rr][Cc][Ee][Ss];
RESTORE: [Rr][Ee][Ss][Tt][Oo][Rr][Ee];
RESTRICTIVE: [Rr][Ee][Ss][Tt][Rr][Ii][Cc][Tt][Ii][Vv][Ee];
RESUME: [Rr][Ee][Ss][Uu][Mm][Ee];
RETURNS: [Rr][Ee][Tt][Uu][Rr][Nn][Ss];
REVOKE: [Rr][Ee][Vv][Oo][Kk][Ee];
REWRITTEN: [Rr][Ee][Ww][Rr][Ii][Tt][Tt][Ee][Nn];
RIGHT: [Rr][Ii][Gg][Hh][Tt];
RLIKE: [Rr][Ll][Ii][Kk][Ee];
ROLE: [Rr][Oo][Ll][Ee];
ROLES: [Rr][Oo][Ll][Ee][Ss];
ROLLBACK: [Rr][Oo][Ll][Ll][Bb][Aa][Cc][Kk];
ROLLUP: [Rr][Oo][Ll][Ll][Uu][Pp];
ROUTINE: [Rr][Oo][Uu][Tt][Ii][Nn][Ee];
ROW: [Rr][Oo][Ww];
ROWS: [Rr][Oo][Ww][Ss];
S3: [Ss]'3';
SAMPLE: [Ss][Aa][Mm][Pp][Ll][Ee];
SCHEDULE: [Ss][Cc][Hh][Ee][Dd][Uu][Ll][Ee];
SCHEDULER: [Ss][Cc][Hh][Ee][Dd][Uu][Ll][Ee][Rr];
SCHEMA: [Ss][Cc][Hh][Ee][Mm][Aa];
SCHEMAS: [Ss][Cc][Hh][Ee][Mm][Aa][Ss];
SECOND: [Ss][Ee][Cc][Oo][Nn][Dd];
SELECT: [Ss][Ee][Ll][Ee][Cc][Tt];
SEMI: [Ss][Ee][Mm][Ii];
SEQUENCE: [Ss][Ee][Qq][Uu][Ee][Nn][Cc][Ee];
SERIALIZABLE: [Ss][Ee][Rr][Ii][Aa][Ll][Ii][Zz][Aa][Bb][Ll][Ee];
SESSION: [Ss][Ee][Ss][Ii][Oo][Nn];
SET: [Ss][Ee][Tt];
SETS: [Ss][Ee][Tt][Ss];
SHAPE: [Ss][Hh][Aa][Pp][Ee];
SHOW: [Ss][Hh][Oo][Ww];
SIGNED: [Ss][Ii][Gg][Nn][Ee][Dd];
SKEW: [Ss][Kk][Ee][Ww];
SMALLINT: [Ss][Mm][Aa][Ll][Ll][Ii][Nn][Tt];
SNAPSHOT: [Ss][Nn][Aa][Pp][Ss][Hh][Oo][Tt];
SONAME: [Ss][Oo][Nn][Aa][Mm][Ee];
SPLIT: [Ss][Pp][Ll][Ii][Tt];
SQL: [Ss][Qq][Ll];
SQL_BLOCK_RULE: [Ss][Qq][Ll]'_'[Bb][Ll][Oo][Cc][Kk]'_'[Rr][Uu][Ll][Ee];
STAGES: [Ss][Tt][Aa][Gg][Ee][Ss];
START: [Ss][Tt][Aa][Rr][Tt];
STARTS: [Ss][Tt][Aa][Rr][Tt][Ss];
STATS: [Ss][Tt][Aa][Tt][Ss];
STATUS: [Ss][Tt][Aa][Tt][Uu][Ss];
STOP: [Ss][Tt][Oo][Pp];
STORAGE: [Ss][Tt][Oo][Rr][Aa][Gg][Ee];
STREAM: [Ss][Tt][Rr][Ee][Aa][Mm];
STREAMING: [Ss][Tt][Rr][Ee][Aa][Mm][Ii][Nn][Gg];
STRING: [Ss][Tt][Rr][Ii][Nn][Gg];
STRUCT: [Ss][Tt][Rr][Uu][Cc][Tt];
SUBDATE: [Ss][Uu][Bb][Dd][Aa][Tt][Ee];
SUM: [Ss][Uu][Mm];
SUPERUSER: [Ss][Uu][Pp][Ee][Rr][Uu][Ss][Ee][Rr];
SWITCH: [Ss][Ww][Ii][Tt][Cc][Hh];
SYNC: [Ss][Yy][Nn][Cc];
SYSTEM: [Ss][Yy][Ss][Tt][Ee][Mm];
TABLE: [Tt][Aa][Bb][Ll][Ee];
TABLES: [Tt][Aa][Bb][Ll][Ee][Ss];
TABLESAMPLE: [Tt][Aa][Bb][Ll][Ee][Ss][Aa][Mm][Pp][Ll][Ee];
TABLET: [Tt][Aa][Bb][Ll][Ee][Tt];
TABLETS: [Tt][Aa][Bb][Ll][Ee][Tt][Ss];
TASK: [Tt][Aa][Ss][Kk];
TASKS: [Tt][Aa][Ss][Kk][Ss];
TEMPORARY: [Tt][Ee][Mm][Pp][Oo][Rr][Aa][Rr][Yy];
TERMINATED: [Tt][Ee][Rr][Mm][Ii][Nn][Aa][Tt][Ee][Dd];
TEXT: [Tt][Ee][Xx][Tt];
THAN: [Tt][Hh][Aa][Nn];
THEN: [Tt][Hh][Ee][Nn];
TIME: [Tt][Ii][Mm][Ee];
TIMESTAMP: [Tt][Ii][Mm][Ee][Ss][Tt][Aa][Mm][Pp];
TIMESTAMPADD: [Tt][Ii][Mm][Ee][Ss][Tt][Aa][Mm][Pp][Aa][Dd][Dd];
TIMESTAMPDIFF: [Tt][Ii][Mm][Ee][Ss][Tt][Aa][Mm][Pp][Dd][Ii][Ff][Ff];
TINYINT: [Tt][Ii][Nn][Yy][Ii][Nn][Tt];
TO: [Tt][Oo];
TRANSACTION: [Tt][Rr][Aa][Nn][Ss][Aa][Cc][Tt][Ii][Oo][Nn];
TRASH: [Tt][Rr][Aa][Ss][Hh];
TREE: [Tt][Rr][Ee][Ee];
TRIGGERS: [Tt][Rr][Ii][Gg][Gg][Ee][Rr][Ss];
TRIM: [Tt][Rr][Ii][Mm];
TRUE: [Tt][Rr][Uu][Ee];
TRUNCATE: [Tt][Rr][Uu][Nn][Cc][Aa][Tt][Ee];
PE: [Tt][Yy][Pp][Ee];
TYPECAST: [Tt][Yy][Pp][Ee]'_'[Cc][Aa][Ss][Tt];
TYPES: [Tt][Yy][Pp][Ee][Ss];
UNBOUNDED: [Uu][Nn][Bb][Oo][Uu][Nn][Dd][Ee][Dd];
UNCOMMITTED: [Uu][Nn][Cc][Oo][Mm][Mm][Ii][Tt][Tt][Ee][Dd];
UNINSTALL: [Uu][Nn][Ii][Nn][Ss][Tt][Aa][Ll][Ll];
UNION: [Uu][Nn][Ii][Oo][Nn];
UNIQUE: [Uu][Nn][Ii][Qq][Uu][Ee];
UNLOCK: [Uu][Nn][Ll][Oo][Cc][Kk];
UNSIGNED: [Uu][Nn][Ss][Ii][Gg][Nn][Ee][Dd];
UP: [Uu][Pp];
UPDATE: [Uu][Pp][Dd][Aa][Tt][Ee];
USE: [Uu][Ss][Ee];
USER: [Uu][Ss][Ee][Rr];
USING: [Uu][Ss][Ii][Nn][Gg];
VALUE: [Vv][Aa][Ll][Uu][Ee];
VALUES: [Vv][Aa][Ll][Uu][Ee][Ss];
VARCHAR: [Vv][Aa][Rr][Cc][Hh][Aa][Rr];
VARIABLES: [Vv][Aa][Rr][Ii][Aa][Bb][Ll][Ee][Ss];
VARIANT: [Vv][Aa][Rr][Ii][Aa][Nn][Tt];
VAULT: [Vv][Aa][Uu][Ll][Tt];
VERBOSE: [Vv][Ee][Rr][Bb][Oo][Ss][Ee];
VERSION: [Vv][Ee][Rr][Ss][Ii][Oo][Nn];
VIEW: [Vv][Ii][Ee][Ww];
WARM: [Ww][Aa][Rr][Mm];
WARNINGS: [Ww][Aa][Rr][Nn][Ii][Nn][Gg][Ss];
WEEK: [Ww][Ee][Ee][Kk];
WHEN: [Ww][Hh][Ee][Nn];
WHERE: [Ww][Hh][Ee][Rr][Ee];
WHITELIST: [Ww][Hh][Ii][Tt][Ee][Ll][Ii][Ss][Tt];
WITH: [Ww][Ii][Tt][Hh];
WORK: [Ww][Oo][Rr][Kk];
WORKLOAD: [Ww][Oo][Rr][Kk][Ll][Oo][Aa][Dd];
WRITE: [Ww][Rr][Ii][Tt][Ee];
XOR: [Xx][Oo][Rr];
YEAR: [Yy][Ee][Aa][Rr];
//--DORIS-KEYWORD-LIST-END
//============================
// End of the keywords list
//============================

EQ  : '=' | '==';
NSEQ: '<=>';
NEQ : '<>' | '!=';
LT  : '<';
LTE : '<=' | '!>';
GT  : '>';
GTE : '>=' | '!<';

PLUS: '+';
SUBTRACT: '-';
ASTERISK: '*';
SLASH: '/';
MOD: '%';
TILDE: '~';
AMPERSAND: '&';
LOGICALAND: '&&';
LOGICALNOT: '!';
PIPE: '|';
DOUBLEPIPES: '||';
HAT: '^';
COLON: ':';
ARROW: '->';
HINT_START: '/*+';
HINT_END: '*/';
ATSIGN: '@';
DOUBLEATSIGN: '@@';

STRING_LITERAL
    : '\'' ('\\'. | '\'\'' | ~('\'' | '\\'))* '\''
    | '"' ( '\\'. | '""' | ~('"'| '\\') )* '"'
    | 'R\'' (~'\'')* '\''
    | 'R"'(~'"')* '"'
    ;

LEADING_STRING
    : LEFT_BRACE
    | RIGHT_BRACE
    | LEFT_BRACKET
    | RIGHT_BRACKET
    ;

BIGINT_LITERAL
    : DIGIT+ 'L'
    ;

SMALLINT_LITERAL
    : DIGIT+ 'S'
    ;

TINYINT_LITERAL
    : DIGIT+ 'Y'
    ;

INTEGER_VALUE
    : DIGIT+
    ;

EXPONENT_VALUE
    : DIGIT+ EXPONENT
    | DECIMAL_DIGITS EXPONENT {isValidDecimal()}?
    ;

DECIMAL_VALUE
    : DECIMAL_DIGITS {isValidDecimal()}?
    ;

BIGDECIMAL_LITERAL
    : DIGIT+ EXPONENT? 'BD'
    | DECIMAL_DIGITS EXPONENT? 'BD' {isValidDecimal()}?
    ;

IDENTIFIER
    : (LETTER | DIGIT | '_')+
    ;

BACKQUOTED_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;

fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment EXPONENT
    : 'E' [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;

SIMPLE_COMMENT
    : '--' ('\\\n' | ~[\r\n])* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' {!isHint()}? ( BRACKETED_COMMENT | . )*? ('*/' | {markUnclosedComment();} EOF) -> channel(HIDDEN)
    ;

FROM_DUAL
    : 'FROM' WS+ 'DUAL' -> channel(HIDDEN);

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;
