# SQL data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Barber`
(
    `barber_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT COLLATE NOCASE

);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Barber_name` ON `Barber` (`name`);

CREATE TABLE IF NOT EXISTS `Appointment`
(
    `appointment_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `barber_id`      INTEGER                           NOT NULL,
    `service_id`     INTEGER                           NOT NULL,
    `client`         TEXT COLLATE NOCASE,
    `date`           INTEGER,
    `duration`       INTEGER                           NOT NULL,
    `status`         INTEGER,
    `notes`          TEXT,
    FOREIGN KEY (`barber_id`) REFERENCES `Barber` (`barber_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`service_id`) REFERENCES `Appointment` (`service_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Appointment_service_id` ON `Appointment` (`service_id`);

CREATE INDEX IF NOT EXISTS `index_Appointment_client` ON `Appointment` (`client`);

CREATE INDEX IF NOT EXISTS `index_Appointment_date` ON `Appointment` (`date`);

CREATE TABLE IF NOT EXISTS `Service` (`service_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT COLLATE NOCASE, `duration` INTEGER NOT NULL, `description` TEXT);
```

[Download](ddl.sql)
