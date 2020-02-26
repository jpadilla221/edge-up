{
  "formatVersion": 1,
  "database": {
    "version": 1,
    "identityHash": "69fbe7de2209be5489644d2a63d4fda0",
    "entities": [
      {
        "tableName": "Barber",
        "createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`barber_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT COLLATE NOCASE)",
        "fields": [
          {
            "fieldPath": "id",
            "columnName": "barber_id",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "name",
            "columnName": "name",
            "affinity": "TEXT",
            "notNull": false
          }
        ],
        "primaryKey": {
          "columnNames": [
            "barber_id"
          ],
          "autoGenerate": true
        },
        "indices": [
          {
            "name": "index_Barber_name",
            "unique": true,
            "columnNames": [
              "name"
            ],
            "createSql": "CREATE UNIQUE INDEX IF NOT EXISTS `index_Barber_name` ON `${TABLE_NAME}` (`name`)"
          }
        ],
        "foreignKeys": []
      },
      {
        "tableName": "Appointment",
        "createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`appointment_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `barber_id` INTEGER NOT NULL, `service_id` INTEGER NOT NULL, `client` TEXT COLLATE NOCASE, `date` INTEGER, `duration` INTEGER NOT NULL, `status` INTEGER, `notes` TEXT, FOREIGN KEY(`barber_id`) REFERENCES `Barber`(`barber_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`service_id`) REFERENCES `Service`(`service_id`) ON UPDATE NO ACTION ON DELETE CASCADE )",
        "fields": [
          {
            "fieldPath": "id",
            "columnName": "appointment_id",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "barberId",
            "columnName": "barber_id",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "serviceId",
            "columnName": "service_id",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "client",
            "columnName": "client",
            "affinity": "TEXT",
            "notNull": false
          },
          {
            "fieldPath": "date",
            "columnName": "date",
            "affinity": "INTEGER",
            "notNull": false
          },
          {
            "fieldPath": "duration",
            "columnName": "duration",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "status",
            "columnName": "status",
            "affinity": "INTEGER",
            "notNull": false
          },
          {
            "fieldPath": "notes",
            "columnName": "notes",
            "affinity": "TEXT",
            "notNull": false
          }
        ],
        "primaryKey": {
          "columnNames": [
            "appointment_id"
          ],
          "autoGenerate": true
        },
        "indices": [
          {
            "name": "index_Appointment_barber_id",
            "unique": false,
            "columnNames": [
              "barber_id"
            ],
            "createSql": "CREATE INDEX IF NOT EXISTS `index_Appointment_barber_id` ON `${TABLE_NAME}` (`barber_id`)"
          },
          {
            "name": "index_Appointment_service_id",
            "unique": false,
            "columnNames": [
              "service_id"
            ],
            "createSql": "CREATE INDEX IF NOT EXISTS `index_Appointment_service_id` ON `${TABLE_NAME}` (`service_id`)"
          },
          {
            "name": "index_Appointment_client",
            "unique": false,
            "columnNames": [
              "client"
            ],
            "createSql": "CREATE INDEX IF NOT EXISTS `index_Appointment_client` ON `${TABLE_NAME}` (`client`)"
          },
          {
            "name": "index_Appointment_date",
            "unique": false,
            "columnNames": [
              "date"
            ],
            "createSql": "CREATE INDEX IF NOT EXISTS `index_Appointment_date` ON `${TABLE_NAME}` (`date`)"
          }
        ],
        "foreignKeys": [
          {
            "table": "Barber",
            "onDelete": "CASCADE",
            "onUpdate": "NO ACTION",
            "columns": [
              "barber_id"
            ],
            "referencedColumns": [
              "barber_id"
            ]
          },
          {
            "table": "Service",
            "onDelete": "CASCADE",
            "onUpdate": "NO ACTION",
            "columns": [
              "service_id"
            ],
            "referencedColumns": [
              "service_id"
            ]
          }
        ]
      },
      {
        "tableName": "Service",
        "createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`service_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT COLLATE NOCASE, `duration` INTEGER NOT NULL, `description` TEXT)",
        "fields": [
          {
            "fieldPath": "id",
            "columnName": "service_id",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "name",
            "columnName": "name",
            "affinity": "TEXT",
            "notNull": false
          },
          {
            "fieldPath": "duration",
            "columnName": "duration",
            "affinity": "INTEGER",
            "notNull": true
          },
          {
            "fieldPath": "description",
            "columnName": "description",
            "affinity": "TEXT",
            "notNull": false
          }
        ],
        "primaryKey": {
          "columnNames": [
            "service_id"
          ],
          "autoGenerate": true
        },
        "indices": [],
        "foreignKeys": []
      }
    ],
    "views": [],
    "setupQueries": [
      "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)",
      "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '69fbe7de2209be5489644d2a63d4fda0')"
    ]
  }
}