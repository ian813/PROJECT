
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- user를 관리할 userTable 만들기
CREATE TABLE IF NOT EXISTS `mydb`.`userTable` (
-- id를 primary key로 생성
  `id` INT NOT NULL AUTO_INCREMENT,
  `uId` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `isLogin` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- user들끼리 팔로우하는 정보를 관리할 followTable 만들기
CREATE TABLE IF NOT EXISTS `mydb`.`followTable` (
-- id를 primary key로 생성
-- userTable의 uId를 참조
  `id` INT NOT NULL AUTO_INCREMENT,
  `uId` INT NOT NULL,
  `userNickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_followTable_userTable1_idx` (`uId` ASC),
  CONSTRAINT `fk_followTable_userTable1`
    FOREIGN KEY (`uId`)
    REFERENCES `mydb`.`userTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- video를 관리할 videoTable 생성
CREATE TABLE IF NOT EXISTS `mydb`.`videoTable` (
-- id를 primary key로 생성
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `fitPartName` VARCHAR(45) NOT NULL,
  `youtubeId` VARCHAR(45) NOT NULL,
  `channelName` VARCHAR(45) NOT NULL,
  `viewCnt` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- 비디오에 대한 review를 관리할 reviewTable 생성
CREATE TABLE IF NOT EXISTS `mydb`.`reviewTable` (
-- id를 primary key로 생성
-- videoTable의 vId를 참조
  `id` INT NOT NULL AUTO_INCREMENT,
  `vId` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `viewCnt` INT NOT NULL,
  `regDate` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reviewTable_videoTable_idx` (`vId` ASC),
  CONSTRAINT `fk_reviewTable_videoTable`
    FOREIGN KEY (`vId`)
    REFERENCES `mydb`.`videoTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- 찜 영상 데이터를 관리할 wishList 테이블 만들기
CREATE TABLE IF NOT EXISTS `mydb`.`wishList` (
-- id를 primary key로 생성
-- userTable의 uId와 vieoTable의 vId를 참조
  `id` INT NOT NULL AUTO_INCREMENT,
  `uId` INT NOT NULL,
  `vId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_wishList_userTable1_idx` (`uId` ASC),
  INDEX `fk_wishList_videoTable1_idx` (`vId` ASC),
  CONSTRAINT `fk_wishList_userTable1`
    FOREIGN KEY (`uId`)
    REFERENCES `mydb`.`userTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wishList_videoTable1`
    FOREIGN KEY (`vId`)
    REFERENCES `mydb`.`videoTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- userTable에 데이터 집어넣기
insert into userTable(`uId`, `password`, `nickname`, `email`, `isLogin`)
values('ssafy1', 'user-hu9kz5lg6l','alice','alice.ssay.com', 1);
select * from userTable; 

-- followTable에 데이터 집어넣기
insert into followTable(`uId`, `userNickname`)
values
(1, 'sung');
select * from followTable;

-- videoTable에 데이터 집어넣기
insert into videoTable(`title`,`fitPartName` ,`youtubeId` ,`channelName` ,`viewCnt`)
values
('죽어라 운동해도 프레임이 넓어지지 않았던 이유+방법','동기부여','sung','Sung Cheol Bong ', 357695 );
select * from videoTable;

-- reviewTable에 데이터 집어넣기
insert into reviewTable(`vId` ,`writer`,`content`,`viewCnt` ,`regDate`)
values
(1,'user-hu9kz5lg6l','진짜 마지막쯤엔 거의 울면서 했어요.. 어떻게 그 땡볕 아래에서 이 운동을 하셨어요?!?! 진짜 대단하셔 ㅠㅠㅠ',793, '2022-03-17');
select * from reviewTable;

-- wishList에 데이터 집어넣기
insert into wishList(`uId`, `vId`)
values
(1, 2);
select * from wishList;
  