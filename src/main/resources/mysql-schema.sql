CREATE TABLE IF NOT EXISTS `Ingredient` (
    `id` VARCHAR(4) NOT NULL,
    `name` VARCHAR(25) NOT NULL,
    `type` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`)
)  COMMENT='配料';

CREATE TABLE IF NOT EXISTS `Taco` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `createdAt` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
)  COMMENT='墨西哥煎玉米卷';

CREATE TABLE IF NOT EXISTS `Taco_Ingredients` (
    `taco` BIGINT NOT NULL,
    `ingredient` VARCHAR(4) NOT NULL,
    CONSTRAINT `fk_taco_id` FOREIGN KEY (`taco`)
        REFERENCES `taco` (`id`),
    CONSTRAINT `fk_ingredient_id` FOREIGN KEY (`ingredient`)
        REFERENCES `ingredient` (`id`)
)  COMMENT='Taco配料关联表';

CREATE TABLE IF NOT EXISTS `Taco_Order` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `deliveryName` VARCHAR(50) NOT NULL,
    `deliveryStreet` VARCHAR(50) NOT NULL,
    `deliveryCity` VARCHAR(50) NOT NULL,
    `deliveryState` VARCHAR(2) NOT NULL,
    `deliveryZip` VARCHAR(10) NOT NULL,
    `ccNumber` VARCHAR(16) NOT NULL,
    `ccExpiration` VARCHAR(5) NOT NULL,
    `ccCVV` VARCHAR(3) NOT NULL,
    `placedAt` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
)  COMMENT='Taco订单表';

CREATE TABLE IF NOT EXISTS `Taco_Order_Tacos` (
    `tacoOrder` BIGINT NOT NULL,
    `taco` BIGINT NOT NULL,
    CONSTRAINT `fk_taco_order_id` FOREIGN KEY (`tacoOrder`)
        REFERENCES `Taco_Order` (`id`),
    CONSTRAINT `fk_taco_id2` FOREIGN KEY (`taco`)
        REFERENCES `taco` (`id`)
)  COMMENT='Taco订单表关联表';

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `fullname` VARCHAR(45) DEFAULT NULL,
    `street` VARCHAR(45) DEFAULT NULL,
    `city` VARCHAR(45) DEFAULT NULL,
    `state` VARCHAR(45) DEFAULT NULL,
    `zip` VARCHAR(45) DEFAULT NULL,
    `phone_number` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)  COMMENT='用户表'