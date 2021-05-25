CREATE TABLE `Uzytkownicy/Klienci`
(
  `id_klient` Int(11) NOT NULL,
  `imie` Varchar(20) NOT NULL,
  `nazwisko` Varchar(20) NOT NULL,
  `pesel` Int(11) NOT NULL,
  `miejsce_urodzenia` Varchar(40) NOT NULL,
  `e_mail` Varchar(50) NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Uzytkownicy/Klienci` ADD PRIMARY KEY (`id_klient`)
;

-- Table Tranzakcje

CREATE TABLE `Tranzakcje`
(
  `id_tranzakcje` Int(11) NOT NULL,
  `id_dane` Int(11) NOT NULL,
  `kwota` Double NOT NULL,
  `id_r_tranzakcji` Int(11) NOT NULL,
  `data` Date NOT NULL,
  `cel` Int(11) NOT NULL
) ENGINE = InnoDB
;

CREATE INDEX `IX_Relationship5` ON `Tranzakcje` (`id_r_tranzakcji`)
;

CREATE INDEX `IX_Relationship7` ON `Tranzakcje` (`id_dane`)
;

ALTER TABLE `Tranzakcje` ADD PRIMARY KEY (`id_tranzakcje`)
;

-- Table Stan konta

CREATE TABLE `Stan konta`
(
  `id_stan` Int(11) NOT NULL,
  `stan_konta` Double NOT NULL,
  `czy_debet` Bool NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Stan konta` ADD PRIMARY KEY (`id_stan`)
;

-- Table Karty_rodzaje

CREATE TABLE `Karty_rodzaje`
(
  `id_k_rodzaje` Int(11) NOT NULL,
  `rodzaj_karty` Varchar(20) NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Karty_rodzaje` ADD PRIMARY KEY (`id_k_rodzaje`)
;

-- Table Karty

CREATE TABLE `Karty`
(
  `id_karty` Int(11) NOT NULL,
  `id_k_rodzaje` Int(11) NOT NULL
) ENGINE = InnoDB
;

CREATE INDEX `IX_Relationship3` ON `Karty` (`id_k_rodzaje`)
;

ALTER TABLE `Karty` ADD PRIMARY KEY (`id_karty`)
;

-- Table Kredyty

CREATE TABLE `Kredyty`
(
  `id_kredyty` Int(11) NOT NULL,
  `kwota_poczatkowa` Double NOT NULL,
  `pozostale_raty` Int(11) NOT NULL,
  `oprocentowanie` Float(2) NOT NULL,
  `pozostalo` Int(11) NOT NULL,
  `kwota_raty` Double NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Kredyty` ADD PRIMARY KEY (`id_kredyty`)
;

-- Table Ubezpieczenia

CREATE TABLE `Ubezpieczenia`
(
  `id_ubezpieczenia` Int(11) NOT NULL,
  `rodzaj_ubezpieczenia` Varchar(40) NOT NULL,
  `rata_miesieczna` Double NOT NULL,
  `termin_waznosci` Date NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Ubezpieczenia` ADD PRIMARY KEY (`id_ubezpieczenia`)
;

-- Table Konta_oszczednosciow/lokaty

CREATE TABLE `Konta_oszczednosciow/lokaty`
(
  `id_k_l` Int(11) NOT NULL,
  `oprocentowanie` Float(2) NOT NULL,
  `koszt_konta/lokaty` Float(2) NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Konta_oszczednosciow/lokaty` ADD PRIMARY KEY (`id_k_l`)
;

-- Table Dane_konto

CREATE TABLE `Dane_konto`
(
  `id_dane` Int(11) NOT NULL,
  `id_klient` Int(11) NOT NULL,
  `login` Varchar(30) NOT NULL,
  `hasze` Varchar(50) NOT NULL,
  `id_karty` Int(11) NOT NULL,
  `id_stan` Int(11) NOT NULL,
  `id_k_l` Int(11) NOT NULL,
  `id_kredyty` Int(11) NOT NULL,
  `id_ubezpieczenia` Int(11) NOT NULL,
  `pin` Int(4) NOT NULL
) ENGINE = InnoDB
;

CREATE INDEX `IX_Relationship1` ON `Dane_konto` (`id_klient`)
;

CREATE INDEX `IX_Relationship4` ON `Dane_konto` (`id_stan`)
;

CREATE INDEX `IX_Relationship8` ON `Dane_konto` (`id_ubezpieczenia`)
;

CREATE INDEX `IX_Relationship9` ON `Dane_konto` (`id_kredyty`)
;

CREATE INDEX `IX_Relationship10` ON `Dane_konto` (`id_k_l`)
;

CREATE INDEX `IX_Relationship11` ON `Dane_konto` (`id_karty`)
;

ALTER TABLE `Dane_konto` ADD PRIMARY KEY (`id_dane`)
;

-- Table Rodzaje Tranzakcji

CREATE TABLE `Rodzaje Tranzakcji`
(
  `id_r_tranzakcji` Int(11) NOT NULL,
  `rodzaj_tranzkacji` Varchar(20) NOT NULL
) ENGINE = InnoDB
;

ALTER TABLE `Rodzaje Tranzakcji` ADD PRIMARY KEY (`id_r_tranzakcji`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `Dane_konto` ADD CONSTRAINT `uzytkownicy-dane` FOREIGN KEY (`id_klient`) REFERENCES `Uzytkownicy/Klienci` (`id_klient`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Karty` ADD CONSTRAINT `karty-rodzajekart` FOREIGN KEY (`id_k_rodzaje`) REFERENCES `Karty_rodzaje` (`id_k_rodzaje`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Dane_konto` ADD CONSTRAINT `stan-dane` FOREIGN KEY (`id_stan`) REFERENCES `Stan konta` (`id_stan`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Tranzakcje` ADD CONSTRAINT `rodzajetranzakcji-dane` FOREIGN KEY (`id_r_tranzakcji`) REFERENCES `Rodzaje Tranzakcji` (`id_r_tranzakcji`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Tranzakcje` ADD CONSTRAINT `tranzakcje-dane` FOREIGN KEY (`id_dane`) REFERENCES `Dane_konto` (`id_dane`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Dane_konto` ADD CONSTRAINT `ubezpieczenia-dane` FOREIGN KEY (`id_ubezpieczenia`) REFERENCES `Ubezpieczenia` (`id_ubezpieczenia`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Dane_konto` ADD CONSTRAINT `kredyty-dane` FOREIGN KEY (`id_kredyty`) REFERENCES `Kredyty` (`id_kredyty`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Dane_konto` ADD CONSTRAINT `konta-dane` FOREIGN KEY (`id_k_l`) REFERENCES `Konta_oszczednosciow/lokaty` (`id_k_l`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Dane_konto` ADD CONSTRAINT `karty-dane` FOREIGN KEY (`id_karty`) REFERENCES `Karty` (`id_karty`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

