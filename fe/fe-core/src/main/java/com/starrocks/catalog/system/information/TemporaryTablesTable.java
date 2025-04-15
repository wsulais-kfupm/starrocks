// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.starrocks.catalog.system.information;

import com.starrocks.catalog.PrimitiveType;
import com.starrocks.catalog.ScalarType;
import com.starrocks.catalog.Table;
import com.starrocks.catalog.system.SystemId;
import com.starrocks.catalog.system.SystemTable;
import com.starrocks.thrift.TSchemaTableType;

import static com.starrocks.catalog.system.SystemTable.FN_REFLEN;
import static com.starrocks.catalog.system.SystemTable.NAME_CHAR_LEN;
import static com.starrocks.catalog.system.SystemTable.virtualTableBuilder;

public class TemporaryTablesTable {
    public static final int MY_CS_NAME_SIZE = 32;
    public static final String NAME = "temp_tables";

    public static SystemTable create() {
      return new SystemTable(SystemId.TEMP_TABLES_ID, NAME, Table.TableType.SCHEMA,
				virtualTableBuilder()
                .column("SESSION", ScalarType.createVarchar(128))
                .column("TABLE_ID", ScalarType.createType(PrimitiveType.BIGINT))
                .build(), TSchemaTableType.SCH_TEMP_TABLES);
    }
}
