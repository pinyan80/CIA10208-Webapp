CREATE DATABASE IF NOT EXISTS morningcode;
USE morningcode;



DROP TABLE IF EXISTS meal_customization_details;
DROP TABLE IF EXISTS orddetails;
DROP TABLE IF EXISTS customization_options;
DROP TABLE IF EXISTS collect;
--

DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS meals_types;
DROP TABLE IF EXISTS meal_picture;
--

DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS reservation_time;
DROP TABLE IF EXISTS table_type;
DROP TABLE IF EXISTS reservation_control;
DROP TABLE IF EXISTS sys_argument;




DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS news;
DROP TABLE IF EXISTS forum_reply;
DROP TABLE IF EXISTS post_reports;
DROP TABLE IF EXISTS chat_list;
DROP TABLE IF EXISTS forum_posts;

DROP TABLE IF EXISTS permissions;
DROP TABLE IF EXISTS assign;
DROP TABLE IF EXISTS `function`;
DROP TABLE IF EXISTS `leave`;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS member;

-- 員工
CREATE TABLE employee (
    emp_id INT NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(20) NOT NULL,
    emp_account VARCHAR(10) NOT NULL,
    emp_password VARCHAR(15) NOT NULL,
    emp_phone VARCHAR(20) NOT NULL,
    emp_address VARCHAR(100) NOT NULL,
    emp_email VARCHAR(100) NOT NULL,
    emp_hiredate DATE NOT NULL,
    emp_status TINYINT DEFAULT 0,
    PRIMARY KEY (emp_id)
);


INSERT INTO employee (emp_name, emp_account, emp_password, emp_phone, emp_address, emp_email, emp_hiredate,emp_status) VALUES ('Kathy','kathy','123456','0912345678','台北市', 'aaaa@aaaaa.com', '1993-01-01',0);
INSERT INTO employee (emp_name, emp_account, emp_password, emp_phone, emp_address, emp_email, emp_hiredate,emp_status) VALUES ('Davide','davide','1111111','0911111111','桃園市', 'bbbb@bbbbb.com', '1970-01-01',0);
INSERT INTO employee (emp_name, emp_account, emp_password, emp_phone, emp_address, emp_email, emp_hiredate,emp_status) VALUES ('Kevin','kevin','222222','0922222222','新竹市', 'cccc@cccccc.com', '1960-01-01',0);

-- 功能
CREATE TABLE `function` (
 function_id            INT NOT NULL AUTO_INCREMENT,
 function_name          VARCHAR(10) NOT NULL,
 PRIMARY KEY (function_id)
);

INSERT INTO `function` (function_name) VALUES ('排班編輯');
INSERT INTO `function` (function_name) VALUES ('員工管理');
INSERT INTO `function` (function_name) VALUES ('請假核准');


-- 權限
CREATE TABLE permissions (
emp_id               INT NOT NULL,
function_id          INT NOT NULL,
PRIMARY KEY (emp_id, function_id));

INSERT INTO permissions (emp_id, function_id) VALUES ('1','1');
INSERT INTO permissions (emp_id, function_id) VALUES ('1','2');
INSERT INTO permissions (emp_id, function_id) VALUES ('1','3');

-- 排班
CREATE TABLE assign(
    assign_id           INT NOT NULL AUTO_INCREMENT,
    assign_date         DATE NOT NULL,
    emp_id              INT,
    PRIMARY KEY (assign_id)
);

INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-01', 3);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-02', 2);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-03', 2);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-04', 3);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-05', 2);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-06', 3);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-07', 2);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-08', 3);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-09', 3);
INSERT INTO assign (assign_date,emp_id) VALUES ('2024-06-10', 2);

-- 請假
CREATE TABLE `leave`(
    leave_id             INT NOT NULL AUTO_INCREMENT,
    leave_filingdate     DATETIME NOT NULL,
    emp_id               INT NOT NULL,
    leave_date           DATE NOT NULL,
    leave_status         TINYINT DEFAULT 0,
    leave_approvaldate   DATETIME,
    assignee_id          INT NOT NULL,
    PRIMARY KEY (leave_id)
);

INSERT INTO `leave` (leave_filingdate, emp_id, leave_date, leave_status,leave_approvaldate, assignee_id) 
VALUES ('2024-06-01 17:30:11', 2, '2024-06-05', 1, '2024-06-02 11:00:00', 3);
INSERT INTO `leave` (leave_filingdate, emp_id, leave_date, leave_status, assignee_id) 
VALUES ('2024-06-02 13:30:11', 3, '2024-06-08', 0,2);




-- 會員
CREATE TABLE member (
	mem_no INT AUTO_INCREMENT NOT NULL,
    mem_email VARCHAR(20) NOT NULL UNIQUE,
    mem_name VARCHAR(5) NOT NULL,
    mem_password VARCHAR(15) NOT NULL,
    mem_address VARCHAR(40) NOT NULL,
    mem_phone VARCHAR(10) NOT NULL,
    mem_uid VARCHAR(10) NOT NULL,
    mem_sex VARCHAR(1) NOT NULL,
    mem_dob DATE,
    mem_update DATETIME,
    mem_verified TINYINT Not Null default 0,
    PRIMARY KEY (mem_no)
);
INSERT INTO member ( mem_email, mem_name, mem_password, mem_address, mem_phone, mem_uid, mem_sex, mem_dob, mem_update)
			VALUES ('bibibobo@gmail.com'  ,'周子瑜','123','桃園市中壢區復興路46號9樓','0912345678','A212345678','F','1999-06-14',now());
INSERT INTO member ( mem_email, mem_name, mem_password, mem_address, mem_phone, mem_uid, mem_sex, mem_dob, mem_update)
			VALUES ('bibibobo1@gmail.com'  ,'峮峮','1234','桃園市中壢區復興路46號8樓','0912345679','B212345679','F','1990-04-19',now());
INSERT INTO member ( mem_email, mem_name, mem_password, mem_address, mem_phone, mem_uid, mem_sex, mem_dob, mem_update, mem_verified)
			VALUES ('bibibobo2@gmail.com'  ,'張鈞甯','2234','桃園市中壢區復興路46號7樓','0922345679','C212345670','F','1982-09-04',now(),0);
INSERT INTO member ( mem_email, mem_name, mem_password, mem_address, mem_phone, mem_uid, mem_sex, mem_dob, mem_update, mem_verified)
			VALUES ('bibibobo3@gmail.com'  ,'王淨','3234','桃園市中壢區復興路46號6樓','0932345679','D212345671','F','1998-02-07',now(),0);
INSERT INTO member ( mem_email, mem_name, mem_password, mem_address, mem_phone, mem_uid, mem_sex, mem_dob, mem_update, mem_verified)
			VALUES ('bibibobo4@gmail.com'  ,'許瑋甯','4234','桃園市中壢區復興路46號5樓','0942345679','E212345672','F','1984-08-07',now(),0);
            
-- 訂位時段 
CREATE TABLE reservation_time (
 reservation_time_id               INT NOT NULL AUTO_INCREMENT,
 reservation_time                  TIME NOT NULL,
 
 CONSTRAINT reservation_time_id_pk PRIMARY KEY (reservation_time_id));

INSERT INTO reservation_time (reservation_time) VALUES ('00:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('00:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('01:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('01:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('02:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('02:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('03:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('03:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('04:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('04:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('05:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('05:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('06:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('06:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('07:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('07:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('08:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('08:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('09:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('09:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('10:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('10:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('11:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('11:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('12:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('12:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('13:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('13:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('14:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('14:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('15:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('15:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('16:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('16:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('17:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('17:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('18:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('18:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('19:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('19:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('20:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('20:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('21:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('21:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('22:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('22:30:00');
INSERT INTO reservation_time (reservation_time) VALUES ('23:00:00');
INSERT INTO reservation_time (reservation_time) VALUES ('23:30:00');

-- 桌型
CREATE TABLE table_type (
 table_id              INT NOT NULL AUTO_INCREMENT,
 table_type            INT NOT NULL,
 table_type_number     INT NOT NULL,
 
 CONSTRAINT table_id_pk PRIMARY KEY (table_id));
 
INSERT INTO table_type (table_type,table_type_number) VALUES (2,9);
INSERT INTO table_type (table_type,table_type_number) VALUES (4,6);





-- 討論文章
CREATE TABLE forum_posts (
  post_id int NOT NULL AUTO_INCREMENT,
  mem_no int NOT NULL,
  post_title varchar(100) NOT NULL,
  post_content varchar(2000) NOT NULL,
  post_time datetime NOT NULL,
  post_status tinyint NOT NULL,
  PRIMARY KEY (post_id),
  CONSTRAINT mem_no FOREIGN KEY (mem_no) REFERENCES member(mem_no)
);

INSERT INTO forum_posts VALUES (1,1,'超棒的早餐店','這家早餐店真的太棒了！他們提供的餐點總是讓我覺得充滿活力，可以愉快地開始一天的工作。特別喜歡他們的雞蛋三明治，口感柔軟，味道也非常棒，讓人每次吃都覺得幸福滿滿。店裡的氛圍很溫馨，讓人感覺像回到家一樣。每次來這裡，不管是獨自享用早餐，還是和朋友一起來，都會覺得心情特別好。而且，這裡的價格非常合理，服務也特別周到。真心推薦給所有喜歡美味早餐的人，來這裡一定不會讓你失望的。','2024-01-01 00:00:00',1),
							   (2,2,'方便快捷的早餐體驗','這家早餐店真是讓人滿意，每天早上我都會在這裡開始新的一天。特別要讚揚的是他們的訂餐功能，真的是非常方便。只要在手機上幾下點擊，就能提前預訂好早餐，節省了很多時間。到了店裡，早餐已經準備好了，不用排隊，直接取餐，非常高效。他們的餐點也很不錯，特別是那款培根蛋餅，香氣撲鼻，讓人食指大動。店員們服務也很周到，每次都熱情問候，讓人感覺很舒服。價格合理，質量有保證，真的是上班族的福音。推薦給所有需要方便快捷早餐的人，這家店絕對不會讓你失望。','2024-01-02 00:00:00',1),
                               (3,3,'某位阿姨服務態度很差','某位阿姨服務態度很差，早上都不微笑打招呼...。\n做服務業不能把情緒掛在臉上。','2024-01-03 00:00:00',1);


-- 線上客服
CREATE TABLE chat_list (
  msg_id int NOT NULL AUTO_INCREMENT,
  emp_id int NOT NULL,
  mem_no int NOT NULL,
  content varchar(500) NOT NULL,
  sent_time datetime NOT NULL,
  sender_role int NOT NULL,
  PRIMARY KEY (msg_id),
  CONSTRAINT mem_no_fk FOREIGN KEY (mem_no) REFERENCES member (mem_no),
  CONSTRAINT emp_id_fk FOREIGN KEY (emp_id) REFERENCES employee (emp_id)
);

INSERT INTO chat_list VALUES (1,1,1,'你好，我前天在店裡點了早餐，結果等了20分鐘才拿到。\n而且漢堡都冷掉了。\n希望你們可以改進出餐的速度，謝謝。而且漢堡都冷掉了。\n希望你們可以改進出餐的速度，謝謝。','2024-01-01 00:10:00',0),
							 (2,1,1,'非常感謝您光臨我們的早餐店，並與我們分享您的建議。非常抱歉聽到您在我們店裡經歷不好的感受。\n關於餐點等待時間過長，我們深表歉意。已經向店內工作人員反饋了這一情況。並加強服務流程的管理，力求在短時間為您提供早餐。','2024-01-01 00:12:00',1),
							 (3,1,1,'那個...不好意思，我的蛋餅裡面有頭髮欸...但是我到學校才發現...建議你們的品管要加強啦...不然客人會跑掉','2024-01-02 00:14:00',0),
                             (4,1,1,'您好，非常抱歉讓您有不愉快的用餐體驗。我們對於這次的疏忽感到非常抱歉。已經向店員反應此問題。為了表達歉意，我們為您提供一次的免費餐點，下次光臨時，請告知店員，會為您準備好。','2024-01-02 00:14:30',1);


-- 檢舉紀錄
CREATE TABLE post_reports (
  report_id int NOT NULL AUTO_INCREMENT,
  emp_id int DEFAULT NULL,
  mem_no int NOT NULL,
  post_id int NOT NULL,
  report_reason varchar(200) NOT NULL,
  report_time datetime NOT NULL,
  report_status int NOT NULL,
  PRIMARY KEY (report_id)

);
INSERT INTO post_reports VALUES (1,0,2,3,'內容不實','2024-01-05 00:00:00',0);

-- 回覆文章
CREATE TABLE forum_reply (
  reply_id int NOT NULL AUTO_INCREMENT,
  post_id int NOT NULL,
  mem_no int NOT NULL,
  reply_content varchar(1000) NOT NULL,
  reply_time datetime NOT NULL,
  PRIMARY KEY (reply_id),
  CONSTRAINT post_id FOREIGN KEY (post_id) REFERENCES forum_posts (post_id),
  CONSTRAINT mem_no_fk1 FOREIGN KEY (mem_no) REFERENCES member (mem_no)
);

INSERT INTO forum_reply VALUES (1,1,1,'真的~\\n我也很喜歡這間店！！！','2024-01-01 00:00:00'),
							   (2,1,2,'超好吃的～!','2024-01-01 00:00:00');


-- 最新消息
CREATE TABLE news (
  news_id int NOT NULL AUTO_INCREMENT,
  news_title varchar(50) NOT NULL,
  news_content varchar(1000) NOT NULL,
  news_date datetime NOT NULL,
  PRIMARY KEY (news_id)
);

INSERT INTO news VALUES (1,'暫停營業通知','感謝所有顧客的厚愛，由於員工旅遊，將於6月1日（星期六）至6月5日（星期三）暫停營業。','2024-06-01 00:00:00'),(2,'漲價通知','親愛的顧客們，感謝您一直以來對我們的支持與厚愛。由於原物料成本持續上升，我們不得不對部分餐點價格進行調整，以確保我們能繼續提供高品質的美味早餐。新價格將於6月15日起正式生效。造成不便請見諒。','2024-06-10 00:00:00');

-- 訂單         
CREATE TABLE `order` (
    ord_id             INT NOT NULL AUTO_INCREMENT,
    mem_no             INT NOT NULL,
    ord_type           TINYINT(1) NOT NULL,
    ord_amount         INT NOT NULL,
    ord_status         TINYINT(1) NOT NULL, -- 設定(0:已接單,1:餐點製作中,2:餐點已完成,3:餐點已領取,4:訂單取消)
    ord_builddate      DATETIME NOT NULL,
    ord_reserve_time   DATETIME NOT NULL,
    ord_payment_status TINYINT(1) NOT NULL, -- 設定(0:未付款,1:已付款,2:已申請退款,3:退款完成)
    PRIMARY KEY (ord_id),
    FOREIGN KEY (mem_no) REFERENCES member(mem_no)
    );
    
    INSERT INTO `order` (mem_no, ord_type, ord_amount, ord_status, ord_builddate, ord_reserve_time, ord_payment_status) VALUES (1, 1, 134, 0, '2024-04-13 10:30:00', '2024-04-13 12:15:00', 1);
    



    
-- 客製化選項
CREATE TABLE customization_options (
	 cust_id       INT NOT NULL AUTO_INCREMENT,
	 cust_name     VARCHAR(50) NOT NULL,
	 cust_price    INT NOT NULL,
	 cust_status   TINYINT(1) NOT NULL DEFAULT 1, -- 設定(0:下架,1:上架)
	 cust_note     VARCHAR(50),
	 PRIMARY KEY (cust_id));

INSERT INTO customization_options (cust_name, cust_price, cust_status) VALUES ('加蛋', 15, 1); 


-- 餐點類別
CREATE TABLE meals_types (
 meals_types_id     INT NOT NULL AUTO_INCREMENT,
 meals_types_name   VARCHAR(20) NOT NULL,
  CONSTRAINT meals_types_meals_types_id_pk PRIMARY KEY (meals_types_id));
  
  INSERT INTO meals_types (meals_types_name) VALUES ('吐司');
  INSERT INTO meals_types (meals_types_name) VALUES ('漢堡');
  INSERT INTO meals_types (meals_types_name) VALUES ('蛋餅');
  INSERT INTO meals_types (meals_types_name) VALUES ('飲料');

-- 餐點圖片
CREATE TABLE meal_picture (
 meal_pic_id    INT NOT NULL AUTO_INCREMENT,
 meal_pic       LONGBLOB,
 meal_pic_info  VARCHAR(10) NOT NULL,
 meals_id       INT NOT NULL,
 
 CONSTRAINT meal_picture_meal_pic_id_pk PRIMARY KEY (meal_pic_id));
  
INSERT INTO meal_picture (meal_pic_info, meals_id) VALUES ('吐司',1);
INSERT INTO meal_picture (meal_pic_info, meals_id) VALUES ('漢堡',2);
INSERT INTO meal_picture (meal_pic_info, meals_id) VALUES ('蛋餅',3);
INSERT INTO meal_picture (meal_pic_info, meals_id) VALUES ('飲料',4);

-- 餐點
CREATE TABLE meals (
 meals_id           INT NOT NULL AUTO_INCREMENT,
 meals_types_id     INT NOT NULL,
 meals_name         VARCHAR(10) NOT NULL,
 meals_price        INT NOT NULL,
 meals_description  VARCHAR(100),
 meals_control      TINYINT NOT NULL,
 meals_total_score  INT NOT NULL,
 meals_total_people INT NOT NULL,
 meal_pic_id        INT,

 CONSTRAINT meals_meals_types_id_fk FOREIGN KEY (meals_types_id) REFERENCES meals_types (meals_types_id),
 CONSTRAINT meal_pic_id_fk FOREIGN KEY (meal_pic_id) REFERENCES meal_picture (meal_pic_id),
 CONSTRAINT meals_meals_id_pk PRIMARY KEY (meals_id));
 
INSERT INTO meals ( meals_types_id, meals_name, meals_price, meals_control, meals_total_score, meals_total_people) VALUES (1,'花生吐司',30,1,5,2);
INSERT INTO meals ( meals_types_id, meals_name, meals_price, meals_control, meals_total_score, meals_total_people) VALUES (2,'豬肉漢堡',45,1,5,3);
INSERT INTO meals ( meals_types_id, meals_name, meals_price, meals_control, meals_total_score, meals_total_people) VALUES (3,'起司蛋餅',35,1,5,4);
INSERT INTO meals ( meals_types_id, meals_name, meals_price, meals_control, meals_total_score, meals_total_people) VALUES (4,'紅茶鮮奶',20,1,1,1);

-- 訂單明細
CREATE TABLE orddetails (
    ordd_id                  INT NOT NULL AUTO_INCREMENT,
    ord_id                   INT NOT NULL,
    meals_id                 INT NOT NULL,
    ordd_meals_quantity      INT NOT NULL,
    ordd_meals_amount        INT NOT NULL,
    ordd_meals_status        TINYINT(1) NOT NULL, -- 設定(0:未製作,1:製作中,2:製作完成,3:已取餐)
    meals_comment_id         INT NOT NULL,
    meals_content            VARCHAR(300),
    meals_score              INT NOT NULL DEFAULT 0,
    meals_status             TINYINT(1) NOT NULL DEFAULT 1, -- 設定(0:隱藏,1:顯示)
    meals_time               DATETIME,
    PRIMARY KEY (ordd_id),
    FOREIGN KEY (ord_id) REFERENCES `order`(ord_id),
    FOREIGN KEY (meals_id) REFERENCES meals(meals_id)
);

INSERT INTO orddetails (ord_id, meals_id, ordd_meals_quantity, ordd_meals_amount, ordd_meals_status, meals_comment_id, meals_content, meals_score, meals_status, meals_time) 
VALUES (1, 4, 1, 110, 0, 1, '漢堡好好吃', 5, 1, '2024-02-26 08:45:38');

-- 餐點客製化明細
CREATE TABLE meal_customization_details (
    custom_id   INT NOT NULL AUTO_INCREMENT,
    ordd_id     INT NOT NULL,
    cust_id     INT NOT NULL,
    PRIMARY KEY (custom_id, ordd_id),
	FOREIGN KEY (ordd_id) REFERENCES orddetails(ordd_id),
	FOREIGN KEY (cust_id) REFERENCES customization_options(cust_id)
    );
    
    INSERT INTO meal_customization_details (ordd_id, cust_id) VALUES (1, 1);







-- 預約訂位訂單
CREATE TABLE reservation (
 reservation_id          INT NOT NULL AUTO_INCREMENT,
 mem_no                  INT NOT NULL,
 reservation_eatdate     DATE NOT NULL,
 reservation_num         INT NOT NULL,
 reservation_time_id     INT NOT NULL,
 reservetion_date        DATETIME NOT NULL,
 reservation_status      TINYINT NOT NULL DEFAULT 0,
 table_id                INT NOT NULL,
 resvation_table         INT NOT NULL,
 
 CONSTRAINT reservation_mem_no_fk FOREIGN KEY (mem_no) REFERENCES  member(mem_no),
 CONSTRAINT reservation_time_id_fk FOREIGN KEY (reservation_time_id) REFERENCES  reservation_time(reservation_time_id),
 CONSTRAINT table_id FOREIGN KEY (table_id) REFERENCES  table_type(table_id),
 CONSTRAINT reservation_id_pk PRIMARY KEY (reservation_id));

INSERT INTO reservation (mem_no,reservation_eatdate,reservation_num,reservation_time_id,reservetion_date,reservation_status,table_id,resvation_table)
VALUES(3,'2024-03-22',3,18,'2024-03-18',0,2,1);




-- 收藏
CREATE TABLE collect (
 mem_no    INT NOT NULL,
 meals_id  INT NOT NULL,
 col_time  DATETIME NOT NULL,
 CONSTRAINT collect_mem_no_fk FOREIGN KEY (mem_no) REFERENCES member (mem_no),
 CONSTRAINT collect_meals_id_fk FOREIGN KEY (meals_id) REFERENCES meals (meals_id),
 PRIMARY KEY (mem_no, meals_id));
 
INSERT INTO collect (mem_no, meals_id, col_time) VALUES (1,1,now());


ALTER TABLE assign
ADD CONSTRAINT assign_emp_id_fk FOREIGN KEY (emp_id) REFERENCES employee(emp_id);

ALTER TABLE permissions
ADD CONSTRAINT per_emp_id_fk FOREIGN KEY (emp_id) REFERENCES employee(emp_id);

ALTER TABLE permissions
ADD CONSTRAINT per_fun_id_fk FOREIGN KEY (function_id) REFERENCES `function`(function_id);

ALTER TABLE `leave`
ADD CONSTRAINT leave_emp_id_fk FOREIGN KEY (emp_id) REFERENCES employee(emp_id);
ALTER TABLE `leave`
ADD CONSTRAINT leave_emp_id2_fk FOREIGN KEY (assignee_id) REFERENCES employee(emp_id);








