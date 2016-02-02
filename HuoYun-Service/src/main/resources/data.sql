INSERT INTO Role(id,code,name) VALUES (1,'ADMIN','管理员');
INSERT INTO Role(id,code,name) VALUES (2,'USER','普通用户');

INSERT INTO Company(id,name) VALUES(1,'SAP');

INSERT INTO Department(id,code,name) VALUES(1,'d1','销售部');
INSERT INTO Department(id,code,name) VALUES(2,'d2','客服部');

INSERT INTO Country(id,code,name) VALUES (1,'China','中国');

--中国
INSERT INTO State(id,country_id,code,name) VALUES (1,1,'ShangHai','上海');
INSERT INTO State(id,country_id,code,name) VALUES (2,1,'BeiJing','北京');
INSERT INTO State(id,country_id,code,name) VALUES (3,1,'TianJing','天津');
INSERT INTO State(id,country_id,code,name) VALUES (4,1,'HeBei','河北');
INSERT INTO State(id,country_id,code,name) VALUES (5,1,'ShangXi','山西');
INSERT INTO State(id,country_id,code,name) VALUES (6,1,'NeiMengGu','内蒙古');
INSERT INTO State(id,country_id,code,name) VALUES (7,1,'LiaoNing','辽宁');
INSERT INTO State(id,country_id,code,name) VALUES (8,1,'JiLin','吉林');
INSERT INTO State(id,country_id,code,name) VALUES (9,1,'HeiLongJiang','黑龙江');
INSERT INTO State(id,country_id,code,name) VALUES (10,1,'JiangSu','江苏');
INSERT INTO State(id,country_id,code,name) VALUES (11,1,'ZheJiang','浙江');
INSERT INTO State(id,country_id,code,name) VALUES (12,1,'AnHui','安徽');
INSERT INTO State(id,country_id,code,name) VALUES (13,1,'FuJian','福建');
INSERT INTO State(id,country_id,code,name) VALUES (14,1,'JiangXi','江西');
INSERT INTO State(id,country_id,code,name) VALUES (15,1,'ShanDong','山东');
INSERT INTO State(id,country_id,code,name) VALUES (16,1,'HeNan','河南');
INSERT INTO State(id,country_id,code,name) VALUES (17,1,'HuBei','湖北');
INSERT INTO State(id,country_id,code,name) VALUES (18,1,'HuNan','湖南');
INSERT INTO State(id,country_id,code,name) VALUES (19,1,'GuangDong','广东');
INSERT INTO State(id,country_id,code,name) VALUES (20,1,'GuangXi','广西');
INSERT INTO State(id,country_id,code,name) VALUES (21,1,'HaiNan','海南');
INSERT INTO State(id,country_id,code,name) VALUES (22,1,'ChongQing','重庆');
INSERT INTO State(id,country_id,code,name) VALUES (23,1,'SiChuang','四川');
INSERT INTO State(id,country_id,code,name) VALUES (24,1,'GuiZhou','贵州');
INSERT INTO State(id,country_id,code,name) VALUES (25,1,'YunNan','云南');
INSERT INTO State(id,country_id,code,name) VALUES (26,1,'XiZang','西藏');
INSERT INTO State(id,country_id,code,name) VALUES (27,1,'ShanXi','陕西');
INSERT INTO State(id,country_id,code,name) VALUES (28,1,'GanSu','甘肃');
INSERT INTO State(id,country_id,code,name) VALUES (29,1,'QingHai','青海');
INSERT INTO State(id,country_id,code,name) VALUES (30,1,'NingXia','宁夏');
INSERT INTO State(id,country_id,code,name) VALUES (31,1,'XinJiang','新疆');
INSERT INTO State(id,country_id,code,name) VALUES (32,1,'TaiWan','台湾');
INSERT INTO State(id,country_id,code,name) VALUES (33,1,'XiangGang','香港');
INSERT INTO State(id,country_id,code,name) VALUES (34,1,'AoMen','澳门');

--上海
INSERT INTO City(id,state_id,code,name) VALUES (1,1,'HuangPuQu','黄浦区');
INSERT INTO City(id,state_id,code,name) VALUES (2,1,'LuWanQu','卢湾区');
INSERT INTO City(id,state_id,code,name) VALUES (3,1,'XuHuiQu','徐汇区');
INSERT INTO City(id,state_id,code,name) VALUES (4,1,'ChangNingQu','长宁区');
INSERT INTO City(id,state_id,code,name) VALUES (5,1,'JingAnQu','静安区');
INSERT INTO City(id,state_id,code,name) VALUES (6,1,'PuTuoQu','普陀区');
INSERT INTO City(id,state_id,code,name) VALUES (7,1,'ZhaBeiQu','闸北区');
INSERT INTO City(id,state_id,code,name) VALUES (8,1,'HongKouQu','虹口区');
INSERT INTO City(id,state_id,code,name) VALUES (9,1,'YangPuQu','杨浦区');
INSERT INTO City(id,state_id,code,name) VALUES (10,1,'MinHangQu','闵行区');
INSERT INTO City(id,state_id,code,name) VALUES (11,1,'BaoShanQu','宝山区');
INSERT INTO City(id,state_id,code,name) VALUES (12,1,'JiaDingQu','嘉定区');
INSERT INTO City(id,state_id,code,name) VALUES (13,1,'PuDongXinQu','浦东新区');
INSERT INTO City(id,state_id,code,name) VALUES (14,1,'JinShangQu','金山区');
INSERT INTO City(id,state_id,code,name) VALUES (15,1,'SongJiangQu','松江区');
INSERT INTO City(id,state_id,code,name) VALUES (16,1,'FengXianQu','奉贤区');
INSERT INTO City(id,state_id,code,name) VALUES (17,1,'QingPuQu','青浦区');
INSERT INTO City(id,state_id,code,name) VALUES (18,1,'ChongMingQu','崇明区');

--北京
INSERT INTO City(id,state_id,code,name) VALUES (19,2,'DongCheng','东城');
INSERT INTO City(id,state_id,code,name) VALUES (20,2,'XiCheng','西城');
INSERT INTO City(id,state_id,code,name) VALUES (21,2,'ChaoYang','朝阳');
INSERT INTO City(id,state_id,code,name) VALUES (22,2,'FengTai','丰台');
INSERT INTO City(id,state_id,code,name) VALUES (23,2,'ShiJingShang','石景山');
INSERT INTO City(id,state_id,code,name) VALUES (24,2,'HaiDing','海淀');
INSERT INTO City(id,state_id,code,name) VALUES (25,2,'MenTouGou','门头沟');
INSERT INTO City(id,state_id,code,name) VALUES (26,2,'FangShang','房山');
INSERT INTO City(id,state_id,code,name) VALUES (27,2,'TongZhou','通州');
INSERT INTO City(id,state_id,code,name) VALUES (28,2,'ShunYi','顺义');
INSERT INTO City(id,state_id,code,name) VALUES (29,2,'ChangPin','昌平');
INSERT INTO City(id,state_id,code,name) VALUES (30,2,'DaXing','大兴');
INSERT INTO City(id,state_id,code,name) VALUES (31,2,'PingGu','平谷');
INSERT INTO City(id,state_id,code,name) VALUES (32,2,'HaiRou','怀柔');
INSERT INTO City(id,state_id,code,name) VALUES (33,2,'MiYun','密云');
INSERT INTO City(id,state_id,code,name) VALUES (34,2,'YanQing','延庆');

--天津
INSERT INTO City(id,state_id,code,name) VALUES (35,3,'HePingQu','和平区');
INSERT INTO City(id,state_id,code,name) VALUES (36,3,'HeDongQu','河东区');
INSERT INTO City(id,state_id,code,name) VALUES (37,3,'HeNanQu','河西区');
INSERT INTO City(id,state_id,code,name) VALUES (38,3,'NanKaiQu','南开区');
INSERT INTO City(id,state_id,code,name) VALUES (39,3,'HeBeiQu','河北区');
INSERT INTO City(id,state_id,code,name) VALUES (40,3,'HongQiaoQu','红桥区');
INSERT INTO City(id,state_id,code,name) VALUES (41,3,'HaiBinXinQu','滨海新区');
INSERT INTO City(id,state_id,code,name) VALUES (42,3,'DongLiQu','东丽区');
INSERT INTO City(id,state_id,code,name) VALUES (43,3,'XiQingQu','西青区');
INSERT INTO City(id,state_id,code,name) VALUES (44,3,'JinNanQu','津南区');
INSERT INTO City(id,state_id,code,name) VALUES (45,3,'BeiChenQun','北辰区');
INSERT INTO City(id,state_id,code,name) VALUES (46,3,'NingHeQu','宁河区');
INSERT INTO City(id,state_id,code,name) VALUES (47,3,'WuQingQu','武清区');
INSERT INTO City(id,state_id,code,name) VALUES (48,3,'JingHaiQu','静海区');
INSERT INTO City(id,state_id,code,name) VALUES (49,3,'BaoDiQu','宝坻区');
INSERT INTO City(id,state_id,code,name) VALUES (50,3,'LiXianQu','蓟县区');

--河北
INSERT INTO City(id,state_id,code,name) VALUES (51,4,'ShiJiaZhuang','石家庄');
INSERT INTO City(id,state_id,code,name) VALUES (52,4,'TangShan','唐山');
INSERT INTO City(id,state_id,code,name) VALUES (53,4,'QiHuangDao','秦皇岛');
INSERT INTO City(id,state_id,code,name) VALUES (54,4,'HanDan','邯郸');
INSERT INTO City(id,state_id,code,name) VALUES (55,4,'XingTai','邢台');
INSERT INTO City(id,state_id,code,name) VALUES (56,4,'BaoDing','保定');
INSERT INTO City(id,state_id,code,name) VALUES (57,4,'ZhangJiaKou','张家口');
INSERT INTO City(id,state_id,code,name) VALUES (58,4,'ChengDe','承德');
INSERT INTO City(id,state_id,code,name) VALUES (59,4,'CangZhou','沧州');
INSERT INTO City(id,state_id,code,name) VALUES (60,4,'LangFang','廊坊');
INSERT INTO City(id,state_id,code,name) VALUES (61,4,'HengShui','衡水');

--山西
INSERT INTO City(id,state_id,code,name) VALUES (62,5,'TaiYuan','太原');
INSERT INTO City(id,state_id,code,name) VALUES (63,5,'DaTong','大同');
INSERT INTO City(id,state_id,code,name) VALUES (64,5,'YangQuan','阳泉');
INSERT INTO City(id,state_id,code,name) VALUES (65,5,'ChangZhi','长治');
INSERT INTO City(id,state_id,code,name) VALUES (66,5,'JinCheng','晋城');
INSERT INTO City(id,state_id,code,name) VALUES (67,5,'ShuoZhou','朔州');
INSERT INTO City(id,state_id,code,name) VALUES (68,5,'JinZhong','晋中');
INSERT INTO City(id,state_id,code,name) VALUES (69,5,'YunCheng','运城');
INSERT INTO City(id,state_id,code,name) VALUES (70,5,'XinZhou','忻州');
INSERT INTO City(id,state_id,code,name) VALUES (71,5,'LinFen','临汾');
INSERT INTO City(id,state_id,code,name) VALUES (72,5,'LvLiang','吕梁');

--内蒙古
INSERT INTO City(id,state_id,code,name) VALUES (73,6,'HuHeHaoTe','呼和浩特');
INSERT INTO City(id,state_id,code,name) VALUES (74,6,'BaoTou','包头');
INSERT INTO City(id,state_id,code,name) VALUES (75,6,'WuHai','乌海');
INSERT INTO City(id,state_id,code,name) VALUES (76,6,'ChiFeng','赤峰');
INSERT INTO City(id,state_id,code,name) VALUES (77,6,'TongLiao','通辽');
INSERT INTO City(id,state_id,code,name) VALUES (78,6,'EErDuoSi','鄂尔多斯');
INSERT INTO City(id,state_id,code,name) VALUES (79,6,'HuLunBeiEr','呼伦贝尔');
INSERT INTO City(id,state_id,code,name) VALUES (80,6,'BaYanNaoEr','巴彦淖尔');
INSERT INTO City(id,state_id,code,name) VALUES (81,6,'WuLanChaBu','乌兰察布');
INSERT INTO City(id,state_id,code,name) VALUES (82,6,'XingAn','兴安');
INSERT INTO City(id,state_id,code,name) VALUES (83,6,'XiLinGuoLe','锡林郭勒');
INSERT INTO City(id,state_id,code,name) VALUES (84,6,'ALaShan','阿拉善');

--辽宁
INSERT INTO City(id,state_id,code,name) VALUES (85,7,'ShenYang','沈阳');
INSERT INTO City(id,state_id,code,name) VALUES (86,7,'DaLian','大连');
INSERT INTO City(id,state_id,code,name) VALUES (87,7,'AnShan','鞍山');
INSERT INTO City(id,state_id,code,name) VALUES (88,7,'FuShun','抚顺');
INSERT INTO City(id,state_id,code,name) VALUES (89,7,'BenXi','本溪');
INSERT INTO City(id,state_id,code,name) VALUES (90,7,'DanDong','丹东');
INSERT INTO City(id,state_id,code,name) VALUES (91,7,'JinZhou','锦州');
INSERT INTO City(id,state_id,code,name) VALUES (92,7,'YingKou','营口');
INSERT INTO City(id,state_id,code,name) VALUES (93,7,'FuXin','阜新');
INSERT INTO City(id,state_id,code,name) VALUES (94,7,'LiaoYang','辽阳');
INSERT INTO City(id,state_id,code,name) VALUES (95,7,'PanJin','盘锦');
INSERT INTO City(id,state_id,code,name) VALUES (96,7,'TieLing','铁岭');
INSERT INTO City(id,state_id,code,name) VALUES (97,7,'ChaoYang','朝阳');
INSERT INTO City(id,state_id,code,name) VALUES (98,7,'HuLuDao','葫芦岛');

--吉林
INSERT INTO City(id,state_id,code,name) VALUES (99,8,'ChangChun','长春');
INSERT INTO City(id,state_id,code,name) VALUES (100,8,'JiLin','吉林');
INSERT INTO City(id,state_id,code,name) VALUES (101,8,'SiPing','四平');
INSERT INTO City(id,state_id,code,name) VALUES (102,8,'LiaoYuan','辽源');
INSERT INTO City(id,state_id,code,name) VALUES (103,8,'TongHua','通化');
INSERT INTO City(id,state_id,code,name) VALUES (104,8,'BaiShan','白山');
INSERT INTO City(id,state_id,code,name) VALUES (105,8,'SongYuan','松原');
INSERT INTO City(id,state_id,code,name) VALUES (106,8,'BaiCheng','白城');
INSERT INTO City(id,state_id,code,name) VALUES (107,8,'YanBian','延边');

--黑龙江
INSERT INTO City(id,state_id,code,name) VALUES (108,9,'HaErBin','哈尔滨');
INSERT INTO City(id,state_id,code,name) VALUES (109,9,'QiQiHaEr','齐齐哈尔');
INSERT INTO City(id,state_id,code,name) VALUES (110,9,'JiXi','鸡西');
INSERT INTO City(id,state_id,code,name) VALUES (111,9,'HeGang','鹤岗');
INSERT INTO City(id,state_id,code,name) VALUES (112,9,'ShuangYaShan','双鸭山');
INSERT INTO City(id,state_id,code,name) VALUES (113,9,'DaQing','大庆');
INSERT INTO City(id,state_id,code,name) VALUES (114,9,'YiChun','伊春');
INSERT INTO City(id,state_id,code,name) VALUES (115,9,'JiaMuSi','佳木斯');
INSERT INTO City(id,state_id,code,name) VALUES (116,9,'QiTaiHe','七台河');
INSERT INTO City(id,state_id,code,name) VALUES (117,9,'MuDanJiang','牡丹江');
INSERT INTO City(id,state_id,code,name) VALUES (118,9,'HeiHe','黑河');
INSERT INTO City(id,state_id,code,name) VALUES (119,9,'SuiHua','绥化');
INSERT INTO City(id,state_id,code,name) VALUES (120,9,'YanBian','大兴安岭');

--江苏
INSERT INTO City(id,state_id,code,name) VALUES (121,10,'NanJing','南京');
INSERT INTO City(id,state_id,code,name) VALUES (122,10,'WuXi','无锡');
INSERT INTO City(id,state_id,code,name) VALUES (123,10,'XuZhou','徐州');
INSERT INTO City(id,state_id,code,name) VALUES (124,10,'ChangZhou','常州');
INSERT INTO City(id,state_id,code,name) VALUES (125,10,'SuZhou','苏州');
INSERT INTO City(id,state_id,code,name) VALUES (126,10,'NanTong','南通');
INSERT INTO City(id,state_id,code,name) VALUES (127,10,'LianYunGang','连云港');
INSERT INTO City(id,state_id,code,name) VALUES (128,10,'HuaiAn','淮安');
INSERT INTO City(id,state_id,code,name) VALUES (129,10,'YanCheng','盐城');
INSERT INTO City(id,state_id,code,name) VALUES (130,10,'YangZhou','扬州');
INSERT INTO City(id,state_id,code,name) VALUES (131,10,'ZhenJiang','镇江');
INSERT INTO City(id,state_id,code,name) VALUES (132,10,'TaiZhou','泰州');
INSERT INTO City(id,state_id,code,name) VALUES (133,10,'SuQian','宿迁');

--浙江
INSERT INTO City(id,state_id,code,name) VALUES (134,11,'HangZhou','杭州');
INSERT INTO City(id,state_id,code,name) VALUES (135,11,'NingBo','宁波');
INSERT INTO City(id,state_id,code,name) VALUES (136,11,'WenZhou','温州');
INSERT INTO City(id,state_id,code,name) VALUES (137,11,'JiaZing','嘉兴');
INSERT INTO City(id,state_id,code,name) VALUES (138,11,'HuZhou','湖州');
INSERT INTO City(id,state_id,code,name) VALUES (139,11,'ShaoXing','绍兴');
INSERT INTO City(id,state_id,code,name) VALUES (140,11,'JinHua','金华');
INSERT INTO City(id,state_id,code,name) VALUES (141,11,'QuZhou','衢州');
INSERT INTO City(id,state_id,code,name) VALUES (142,11,'ZhouShan','舟山');
INSERT INTO City(id,state_id,code,name) VALUES (143,11,'TaiZhou','台州');
INSERT INTO City(id,state_id,code,name) VALUES (144,11,'LiShui','丽水');

--安徽
INSERT INTO City(id,state_id,code,name) VALUES (145,12,'hefei','合肥');
INSERT INTO City(id,state_id,code,name) VALUES (146,12,'wuhu','芜湖');
INSERT INTO City(id,state_id,code,name) VALUES (147,12,'bengbu','蚌埠');
INSERT INTO City(id,state_id,code,name) VALUES (148,12,'huainan','淮南');
INSERT INTO City(id,state_id,code,name) VALUES (149,12,'maanshan','马鞍山');
INSERT INTO City(id,state_id,code,name) VALUES (150,12,'huaibei','淮北');
INSERT INTO City(id,state_id,code,name) VALUES (151,12,'tongling','铜陵');
INSERT INTO City(id,state_id,code,name) VALUES (152,12,'anqing','安庆');
INSERT INTO City(id,state_id,code,name) VALUES (153,12,'huangshan','黄山');
INSERT INTO City(id,state_id,code,name) VALUES (154,12,'chuzhou','滁州');
INSERT INTO City(id,state_id,code,name) VALUES (155,12,'fuyang','阜阳');
INSERT INTO City(id,state_id,code,name) VALUES (156,12,'suzhou','宿州');
INSERT INTO City(id,state_id,code,name) VALUES (157,12,'liuan','六安');
INSERT INTO City(id,state_id,code,name) VALUES (158,12,'bozhou','亳州');
INSERT INTO City(id,state_id,code,name) VALUES (159,12,'chizhou','池州');
INSERT INTO City(id,state_id,code,name) VALUES (160,12,'xuancheng','宣城');

--福建
INSERT INTO City(id,state_id,code,name) VALUES (161,13,'fuzhou','福州');
INSERT INTO City(id,state_id,code,name) VALUES (162,13,'xiamen','厦门');
INSERT INTO City(id,state_id,code,name) VALUES (163,13,'putian','莆田');
INSERT INTO City(id,state_id,code,name) VALUES (164,13,'sanming','三明');
INSERT INTO City(id,state_id,code,name) VALUES (165,13,'quanzhou','泉州');
INSERT INTO City(id,state_id,code,name) VALUES (166,13,'zhangzhou','漳州');
INSERT INTO City(id,state_id,code,name) VALUES (167,13,'nanping','南平');
INSERT INTO City(id,state_id,code,name) VALUES (168,13,'longyan','龙岩');
INSERT INTO City(id,state_id,code,name) VALUES (169,13,'ningde','宁德');

--江西
INSERT INTO City(id,state_id,code,name) VALUES (170,14,'nanchang','南昌');
INSERT INTO City(id,state_id,code,name) VALUES (171,14,'jingdezhen','景德镇');
INSERT INTO City(id,state_id,code,name) VALUES (172,14,'pingxiang','萍乡');
INSERT INTO City(id,state_id,code,name) VALUES (173,14,'jiujiang','九江');
INSERT INTO City(id,state_id,code,name) VALUES (174,14,'xinyu','新余');
INSERT INTO City(id,state_id,code,name) VALUES (175,14,'yingtan','鹰潭');
INSERT INTO City(id,state_id,code,name) VALUES (176,14,'ganzhou','赣州');
INSERT INTO City(id,state_id,code,name) VALUES (177,14,'JiAn','吉安');
INSERT INTO City(id,state_id,code,name) VALUES (178,14,'yichun','宜春');
INSERT INTO City(id,state_id,code,name) VALUES (179,14,'fuzhou','抚州');
INSERT INTO City(id,state_id,code,name) VALUES (180,14,'ShangRao','上饶');

--山东
INSERT INTO City(id,state_id,code,name) VALUES (181,15,'jinan','济南');
INSERT INTO City(id,state_id,code,name) VALUES (182,15,'qingdao','青岛');
INSERT INTO City(id,state_id,code,name) VALUES (183,15,'zibo','淄博');
INSERT INTO City(id,state_id,code,name) VALUES (184,15,'zaozhuang','枣庄');
INSERT INTO City(id,state_id,code,name) VALUES (185,15,'dongying','东营');
INSERT INTO City(id,state_id,code,name) VALUES (186,15,'yantai','烟台');
INSERT INTO City(id,state_id,code,name) VALUES (187,15,'weifang','潍坊');
INSERT INTO City(id,state_id,code,name) VALUES (188,15,'jining','济宁');
INSERT INTO City(id,state_id,code,name) VALUES (189,15,'taian','泰安');
INSERT INTO City(id,state_id,code,name) VALUES (190,15,'weihai','威海');
INSERT INTO City(id,state_id,code,name) VALUES (191,15,'rizhao','日照');
INSERT INTO City(id,state_id,code,name) VALUES (192,15,'laiwu','莱芜');
INSERT INTO City(id,state_id,code,name) VALUES (193,15,'linyi','临沂');
INSERT INTO City(id,state_id,code,name) VALUES (194,15,'dezhou','德州');
INSERT INTO City(id,state_id,code,name) VALUES (195,15,'liaoc','聊城');
INSERT INTO City(id,state_id,code,name) VALUES (196,15,'binzhou','滨州');
INSERT INTO City(id,state_id,code,name) VALUES (197,15,'heze','菏泽');

--河南
INSERT INTO City(id,state_id,code,name) VALUES (198,16,'zhengzhou','郑州');
INSERT INTO City(id,state_id,code,name) VALUES (199,16,'kaifeng','开封');
INSERT INTO City(id,state_id,code,name) VALUES (200,16,'luoyang','洛阳');
INSERT INTO City(id,state_id,code,name) VALUES (201,16,'pingdingshan','平顶山');
INSERT INTO City(id,state_id,code,name) VALUES (202,16,'anyang','安阳');
INSERT INTO City(id,state_id,code,name) VALUES (203,16,'hebi','鹤壁');
INSERT INTO City(id,state_id,code,name) VALUES (204,16,'xinxiang','新乡');
INSERT INTO City(id,state_id,code,name) VALUES (205,16,'jiaozuo','焦作');
INSERT INTO City(id,state_id,code,name) VALUES (206,16,'puyang','濮阳');
INSERT INTO City(id,state_id,code,name) VALUES (207,16,'xuchang','许昌');
INSERT INTO City(id,state_id,code,name) VALUES (208,16,'luohe','漯河');
INSERT INTO City(id,state_id,code,name) VALUES (209,16,'sanmenxia','三门峡');
INSERT INTO City(id,state_id,code,name) VALUES (210,16,'nanyang','南阳');
INSERT INTO City(id,state_id,code,name) VALUES (211,16,'shangqiu','商丘');
INSERT INTO City(id,state_id,code,name) VALUES (212,16,'xinyang','信阳');
INSERT INTO City(id,state_id,code,name) VALUES (213,16,'zhoukou','周口');
INSERT INTO City(id,state_id,code,name) VALUES (214,16,'zhumadian','驻马店');
INSERT INTO City(id,state_id,code,name) VALUES (215,16,'jiyuan','济源');

--湖北
INSERT INTO City(id,state_id,code,name) VALUES (216,17,'zhengzhou','武汉');
INSERT INTO City(id,state_id,code,name) VALUES (217,17,'kaifeng','黄石');
INSERT INTO City(id,state_id,code,name) VALUES (218,17,'luoyang','十堰');
INSERT INTO City(id,state_id,code,name) VALUES (219,17,'pingdingshan','宜昌');
INSERT INTO City(id,state_id,code,name) VALUES (220,17,'anyang','襄阳');
INSERT INTO City(id,state_id,code,name) VALUES (221,17,'hebi','鄂州');
INSERT INTO City(id,state_id,code,name) VALUES (222,17,'xinxiang','荆门');
INSERT INTO City(id,state_id,code,name) VALUES (223,17,'jiaozuo','孝感');
INSERT INTO City(id,state_id,code,name) VALUES (224,17,'puyang','荆州');
INSERT INTO City(id,state_id,code,name) VALUES (225,17,'xuchang','黄冈');
INSERT INTO City(id,state_id,code,name) VALUES (226,17,'luohe','咸宁');
INSERT INTO City(id,state_id,code,name) VALUES (227,17,'sanmenxia','随州');
INSERT INTO City(id,state_id,code,name) VALUES (228,17,'nanyang','恩施');
INSERT INTO City(id,state_id,code,name) VALUES (229,17,'shangqiu','仙桃');
INSERT INTO City(id,state_id,code,name) VALUES (230,17,'xinyang','潜江');
INSERT INTO City(id,state_id,code,name) VALUES (231,17,'zhoukou','天门');
INSERT INTO City(id,state_id,code,name) VALUES (232,17,'zhumadian','神农架');

--湖南
INSERT INTO City(id,state_id,code,name) VALUES (233,18,'zhengzhou','长沙');
INSERT INTO City(id,state_id,code,name) VALUES (234,18,'kaifeng','株洲');
INSERT INTO City(id,state_id,code,name) VALUES (235,18,'luoyang','湘潭');
INSERT INTO City(id,state_id,code,name) VALUES (236,18,'pingdingshan','衡阳');
INSERT INTO City(id,state_id,code,name) VALUES (237,18,'anyang','邵阳');
INSERT INTO City(id,state_id,code,name) VALUES (238,18,'hebi','岳阳');
INSERT INTO City(id,state_id,code,name) VALUES (239,18,'xinxiang','常德');
INSERT INTO City(id,state_id,code,name) VALUES (240,18,'jiaozuo','张家界');
INSERT INTO City(id,state_id,code,name) VALUES (241,18,'puyang','益阳');
INSERT INTO City(id,state_id,code,name) VALUES (242,18,'xuchang','郴州');
INSERT INTO City(id,state_id,code,name) VALUES (243,18,'luohe','永州');
INSERT INTO City(id,state_id,code,name) VALUES (244,18,'sanmenxia','怀化');
INSERT INTO City(id,state_id,code,name) VALUES (245,18,'nanyang','娄底');
INSERT INTO City(id,state_id,code,name) VALUES (246,18,'shangqiu','湘西');

--广东
INSERT INTO City(id,state_id,code,name) VALUES (247,19,'zhengzhou','广州');
INSERT INTO City(id,state_id,code,name) VALUES (248,19,'kaifeng','韶关');
INSERT INTO City(id,state_id,code,name) VALUES (249,19,'luoyang','深圳');
INSERT INTO City(id,state_id,code,name) VALUES (250,19,'pingdingshan','珠海');
INSERT INTO City(id,state_id,code,name) VALUES (251,19,'anyang','汕头');
INSERT INTO City(id,state_id,code,name) VALUES (252,19,'hebi','佛山');
INSERT INTO City(id,state_id,code,name) VALUES (253,19,'xinxiang','江门');
INSERT INTO City(id,state_id,code,name) VALUES (254,19,'jiaozuo','湛江');
INSERT INTO City(id,state_id,code,name) VALUES (255,19,'puyang','茂名');
INSERT INTO City(id,state_id,code,name) VALUES (256,19,'xuchang','肇庆');
INSERT INTO City(id,state_id,code,name) VALUES (257,19,'luohe','惠州');
INSERT INTO City(id,state_id,code,name) VALUES (258,19,'sanmenxia','梅州');
INSERT INTO City(id,state_id,code,name) VALUES (259,19,'nanyang','汕尾');
INSERT INTO City(id,state_id,code,name) VALUES (260,19,'shangqiu','河源');
INSERT INTO City(id,state_id,code,name) VALUES (261,19,'xuchang','阳江');
INSERT INTO City(id,state_id,code,name) VALUES (262,19,'luohe','清远');
INSERT INTO City(id,state_id,code,name) VALUES (263,19,'sanmenxia','东莞');
INSERT INTO City(id,state_id,code,name) VALUES (264,19,'nanyang','中山');
INSERT INTO City(id,state_id,code,name) VALUES (265,19,'shangqiu','潮州');
INSERT INTO City(id,state_id,code,name) VALUES (266,19,'nanyang','揭阳');
INSERT INTO City(id,state_id,code,name) VALUES (267,19,'shangqiu','云浮');

--广西
INSERT INTO City(id,state_id,code,name) VALUES (268,20,'zhengzhou','南宁');
INSERT INTO City(id,state_id,code,name) VALUES (269,20,'kaifeng','柳州');
INSERT INTO City(id,state_id,code,name) VALUES (270,20,'luoyang','桂林');
INSERT INTO City(id,state_id,code,name) VALUES (271,20,'pingdingshan','梧州');
INSERT INTO City(id,state_id,code,name) VALUES (272,20,'anyang','北海');
INSERT INTO City(id,state_id,code,name) VALUES (273,20,'hebi','防城港');
INSERT INTO City(id,state_id,code,name) VALUES (274,20,'xinxiang','钦州');
INSERT INTO City(id,state_id,code,name) VALUES (275,20,'jiaozuo','贵港');
INSERT INTO City(id,state_id,code,name) VALUES (276,20,'puyang','玉林');
INSERT INTO City(id,state_id,code,name) VALUES (277,20,'xuchang','百色');
INSERT INTO City(id,state_id,code,name) VALUES (278,20,'luohe','贺州');
INSERT INTO City(id,state_id,code,name) VALUES (279,20,'sanmenxia','河池');
INSERT INTO City(id,state_id,code,name) VALUES (280,20,'nanyang','来宾');
INSERT INTO City(id,state_id,code,name) VALUES (281,20,'shangqiu','崇左');

--海南
INSERT INTO City(id,state_id,code,name) VALUES (282,21,'zhengzhou','海口');
INSERT INTO City(id,state_id,code,name) VALUES (283,21,'kaifeng','三亚');
INSERT INTO City(id,state_id,code,name) VALUES (284,21,'luoyang','三沙');
INSERT INTO City(id,state_id,code,name) VALUES (285,21,'pingdingshan','五指山');
INSERT INTO City(id,state_id,code,name) VALUES (286,21,'anyang','琼海');
INSERT INTO City(id,state_id,code,name) VALUES (287,21,'hebi','儋州');
INSERT INTO City(id,state_id,code,name) VALUES (288,21,'xinxiang','文昌');
INSERT INTO City(id,state_id,code,name) VALUES (289,21,'jiaozuo','万宁');
INSERT INTO City(id,state_id,code,name) VALUES (290,21,'puyang','东方');
INSERT INTO City(id,state_id,code,name) VALUES (291,21,'xuchang','定安');
INSERT INTO City(id,state_id,code,name) VALUES (292,21,'luohe','屯昌');
INSERT INTO City(id,state_id,code,name) VALUES (293,21,'sanmenxia','澄迈');
INSERT INTO City(id,state_id,code,name) VALUES (294,21,'nanyang','临高');
INSERT INTO City(id,state_id,code,name) VALUES (295,21,'shangqiu','白沙');
INSERT INTO City(id,state_id,code,name) VALUES (296,21,'puyang','昌江');
INSERT INTO City(id,state_id,code,name) VALUES (297,21,'xuchang','乐东');
INSERT INTO City(id,state_id,code,name) VALUES (298,21,'luohe','陵水');
INSERT INTO City(id,state_id,code,name) VALUES (299,21,'sanmenxia','保亭');
INSERT INTO City(id,state_id,code,name) VALUES (300,21,'nanyang','琼中');

--重庆
INSERT INTO City(id,state_id,code,name) VALUES (301,22,'zhengzhou','万州');
INSERT INTO City(id,state_id,code,name) VALUES (302,22,'kaifeng','涪陵');
INSERT INTO City(id,state_id,code,name) VALUES (303,22,'luoyang','渝中');
INSERT INTO City(id,state_id,code,name) VALUES (304,22,'pingdingshan','大渡口');
INSERT INTO City(id,state_id,code,name) VALUES (305,22,'anyang','江北');
INSERT INTO City(id,state_id,code,name) VALUES (306,22,'hebi','沙坪坝');
INSERT INTO City(id,state_id,code,name) VALUES (307,22,'xinxiang','九龙坡');
INSERT INTO City(id,state_id,code,name) VALUES (308,22,'jiaozuo','南岸');
INSERT INTO City(id,state_id,code,name) VALUES (309,22,'puyang','北碚');
INSERT INTO City(id,state_id,code,name) VALUES (310,22,'xuchang','两江新区');
INSERT INTO City(id,state_id,code,name) VALUES (311,22,'luohe','万盛');
INSERT INTO City(id,state_id,code,name) VALUES (312,22,'sanmenxia','双桥');
INSERT INTO City(id,state_id,code,name) VALUES (313,22,'nanyang','渝北');
INSERT INTO City(id,state_id,code,name) VALUES (314,22,'shangqiu','巴南');
INSERT INTO City(id,state_id,code,name) VALUES (315,22,'puyang','长寿');
INSERT INTO City(id,state_id,code,name) VALUES (316,22,'xuchang','綦江');
INSERT INTO City(id,state_id,code,name) VALUES (317,22,'luohe','潼南');
INSERT INTO City(id,state_id,code,name) VALUES (318,22,'sanmenxia','铜梁');
INSERT INTO City(id,state_id,code,name) VALUES (319,22,'nanyang','大足');
INSERT INTO City(id,state_id,code,name) VALUES (320,22,'luohe','荣昌');
INSERT INTO City(id,state_id,code,name) VALUES (321,22,'sanmenxia','璧山');
INSERT INTO City(id,state_id,code,name) VALUES (322,22,'nanyang','梁平');
INSERT INTO City(id,state_id,code,name) VALUES (323,22,'shangqiu','城口');
INSERT INTO City(id,state_id,code,name) VALUES (324,22,'puyang','丰都');
INSERT INTO City(id,state_id,code,name) VALUES (325,22,'xuchang','垫江');
INSERT INTO City(id,state_id,code,name) VALUES (326,22,'luohe','武隆');
INSERT INTO City(id,state_id,code,name) VALUES (327,22,'sanmenxia','忠县');
INSERT INTO City(id,state_id,code,name) VALUES (328,22,'nanyang','开县');
INSERT INTO City(id,state_id,code,name) VALUES (329,22,'luohe','云阳');
INSERT INTO City(id,state_id,code,name) VALUES (330,22,'sanmenxia','奉节');
INSERT INTO City(id,state_id,code,name) VALUES (331,22,'nanyang','巫山');
INSERT INTO City(id,state_id,code,name) VALUES (332,22,'shangqiu','巫溪');
INSERT INTO City(id,state_id,code,name) VALUES (333,22,'puyang','黔江');
INSERT INTO City(id,state_id,code,name) VALUES (334,22,'xuchang','石柱');
INSERT INTO City(id,state_id,code,name) VALUES (335,22,'luohe','秀山');
INSERT INTO City(id,state_id,code,name) VALUES (336,22,'sanmenxia','酉阳');
INSERT INTO City(id,state_id,code,name) VALUES (337,22,'nanyang','彭水');
INSERT INTO City(id,state_id,code,name) VALUES (338,22,'luohe','江津');
INSERT INTO City(id,state_id,code,name) VALUES (339,22,'sanmenxia','合川');
INSERT INTO City(id,state_id,code,name) VALUES (340,22,'nanyang','永川');
INSERT INTO City(id,state_id,code,name) VALUES (341,22,'shangqiu','南川');

--四川
INSERT INTO City(id,state_id,code,name) VALUES (342,23,'zhengzhou','成都');
INSERT INTO City(id,state_id,code,name) VALUES (343,23,'kaifeng','自贡');
INSERT INTO City(id,state_id,code,name) VALUES (344,23,'luoyang','攀枝花');
INSERT INTO City(id,state_id,code,name) VALUES (345,23,'pingdingshan','泸州');
INSERT INTO City(id,state_id,code,name) VALUES (346,23,'anyang','德阳');
INSERT INTO City(id,state_id,code,name) VALUES (347,23,'hebi','绵阳');
INSERT INTO City(id,state_id,code,name) VALUES (348,23,'xinxiang','广元');
INSERT INTO City(id,state_id,code,name) VALUES (349,23,'jiaozuo','遂宁');
INSERT INTO City(id,state_id,code,name) VALUES (350,23,'puyang','内江');
INSERT INTO City(id,state_id,code,name) VALUES (351,23,'xuchang','乐山');
INSERT INTO City(id,state_id,code,name) VALUES (352,23,'luohe','南充');
INSERT INTO City(id,state_id,code,name) VALUES (353,23,'sanmenxia','眉山');
INSERT INTO City(id,state_id,code,name) VALUES (354,23,'nanyang','宜宾');
INSERT INTO City(id,state_id,code,name) VALUES (355,23,'shangqiu','广安');
INSERT INTO City(id,state_id,code,name) VALUES (356,23,'puyang','达州');
INSERT INTO City(id,state_id,code,name) VALUES (357,23,'xuchang','雅安');
INSERT INTO City(id,state_id,code,name) VALUES (358,23,'luohe','巴中');
INSERT INTO City(id,state_id,code,name) VALUES (359,23,'sanmenxia','资阳');
INSERT INTO City(id,state_id,code,name) VALUES (360,23,'nanyang','阿坝');
INSERT INTO City(id,state_id,code,name) VALUES (361,23,'luohe','甘孜');
INSERT INTO City(id,state_id,code,name) VALUES (362,23,'sanmenxia','凉山');

--贵州
INSERT INTO City(id,state_id,code,name) VALUES (363,24,'zhengzhou','贵阳');
INSERT INTO City(id,state_id,code,name) VALUES (364,24,'kaifeng','六盘水');
INSERT INTO City(id,state_id,code,name) VALUES (365,24,'luoyang','遵义');
INSERT INTO City(id,state_id,code,name) VALUES (366,24,'pingdingshan','安顺');
INSERT INTO City(id,state_id,code,name) VALUES (367,24,'anyang','铜仁');
INSERT INTO City(id,state_id,code,name) VALUES (368,24,'hebi','黔西南');
INSERT INTO City(id,state_id,code,name) VALUES (369,24,'xinxiang','毕节');
INSERT INTO City(id,state_id,code,name) VALUES (370,24,'jiaozuo','黔东南');
INSERT INTO City(id,state_id,code,name) VALUES (371,24,'puyang','黔南');

--云南
INSERT INTO City(id,state_id,code,name) VALUES (372,25,'zhengzhou','昆明');
INSERT INTO City(id,state_id,code,name) VALUES (373,25,'kaifeng','曲靖');
INSERT INTO City(id,state_id,code,name) VALUES (374,25,'luoyang','玉溪');
INSERT INTO City(id,state_id,code,name) VALUES (375,25,'pingdingshan','保山');
INSERT INTO City(id,state_id,code,name) VALUES (376,25,'anyang','昭通');
INSERT INTO City(id,state_id,code,name) VALUES (377,25,'hebi','丽江');
INSERT INTO City(id,state_id,code,name) VALUES (378,25,'xinxiang','普洱');
INSERT INTO City(id,state_id,code,name) VALUES (379,25,'jiaozuo','临沧');
INSERT INTO City(id,state_id,code,name) VALUES (380,25,'puyang','楚雄');
INSERT INTO City(id,state_id,code,name) VALUES (381,25,'xinxiang','红河');
INSERT INTO City(id,state_id,code,name) VALUES (382,25,'jiaozuo','文山');
INSERT INTO City(id,state_id,code,name) VALUES (383,25,'puyang','西双版纳');
INSERT INTO City(id,state_id,code,name) VALUES (384,25,'xinxiang','大理');
INSERT INTO City(id,state_id,code,name) VALUES (385,25,'jiaozuo','德宏');
INSERT INTO City(id,state_id,code,name) VALUES (386,25,'puyang','怒江');
INSERT INTO City(id,state_id,code,name) VALUES (387,25,'puyang','迪庆');

--西藏
INSERT INTO City(id,state_id,code,name) VALUES (388,26,'zhengzhou','拉萨');
INSERT INTO City(id,state_id,code,name) VALUES (389,26,'kaifeng','昌都');
INSERT INTO City(id,state_id,code,name) VALUES (390,26,'luoyang','山南');
INSERT INTO City(id,state_id,code,name) VALUES (391,26,'pingdingshan','日喀则');
INSERT INTO City(id,state_id,code,name) VALUES (392,26,'anyang','那曲');
INSERT INTO City(id,state_id,code,name) VALUES (393,26,'hebi','阿里');
INSERT INTO City(id,state_id,code,name) VALUES (394,26,'xinxiang','林芝');

--陕西
INSERT INTO City(id,state_id,code,name) VALUES (395,27,'zhengzhou','西安');
INSERT INTO City(id,state_id,code,name) VALUES (396,27,'kaifeng','铜川');
INSERT INTO City(id,state_id,code,name) VALUES (397,27,'luoyang','宝鸡');
INSERT INTO City(id,state_id,code,name) VALUES (398,27,'pingdingshan','咸阳');
INSERT INTO City(id,state_id,code,name) VALUES (399,27,'anyang','渭南');
INSERT INTO City(id,state_id,code,name) VALUES (400,27,'hebi','延安');
INSERT INTO City(id,state_id,code,name) VALUES (401,27,'xinxiang','汉中');
INSERT INTO City(id,state_id,code,name) VALUES (402,27,'pingdingshan','榆林');
INSERT INTO City(id,state_id,code,name) VALUES (403,27,'anyang','安康');
INSERT INTO City(id,state_id,code,name) VALUES (404,27,'hebi','商洛');

--甘肃
INSERT INTO City(id,state_id,code,name) VALUES (405,28,'zhengzhou','兰州市');
INSERT INTO City(id,state_id,code,name) VALUES (406,28,'kaifeng','嘉峪关');
INSERT INTO City(id,state_id,code,name) VALUES (407,28,'luoyang','金昌');
INSERT INTO City(id,state_id,code,name) VALUES (408,28,'pingdingshan','白银');
INSERT INTO City(id,state_id,code,name) VALUES (409,28,'anyang','天水');
INSERT INTO City(id,state_id,code,name) VALUES (410,28,'hebi','武威');
INSERT INTO City(id,state_id,code,name) VALUES (411,28,'xinxiang','张掖');
INSERT INTO City(id,state_id,code,name) VALUES (412,28,'pingdingshan','平凉');
INSERT INTO City(id,state_id,code,name) VALUES (413,28,'anyang','酒泉');
INSERT INTO City(id,state_id,code,name) VALUES (414,28,'hebi','庆阳');
INSERT INTO City(id,state_id,code,name) VALUES (415,28,'xinxiang','定西');
INSERT INTO City(id,state_id,code,name) VALUES (416,28,'pingdingshan','陇南');
INSERT INTO City(id,state_id,code,name) VALUES (417,28,'anyang','临夏');
INSERT INTO City(id,state_id,code,name) VALUES (418,28,'hebi','甘南');

--青海
INSERT INTO City(id,state_id,code,name) VALUES (419,29,'zhengzhou','西宁');
INSERT INTO City(id,state_id,code,name) VALUES (420,29,'kaifeng','海东');
INSERT INTO City(id,state_id,code,name) VALUES (421,29,'luoyang','海北');
INSERT INTO City(id,state_id,code,name) VALUES (422,29,'pingdingshan','黄南');
INSERT INTO City(id,state_id,code,name) VALUES (423,29,'anyang','海南');
INSERT INTO City(id,state_id,code,name) VALUES (424,29,'hebi','果洛');
INSERT INTO City(id,state_id,code,name) VALUES (425,29,'xinxiang','玉树');
INSERT INTO City(id,state_id,code,name) VALUES (426,29,'pingdingshan','海西');

--宁夏
INSERT INTO City(id,state_id,code,name) VALUES (427,30,'zhengzhou','银川');
INSERT INTO City(id,state_id,code,name) VALUES (428,30,'kaifeng','石嘴山');
INSERT INTO City(id,state_id,code,name) VALUES (429,30,'luoyang','吴忠');
INSERT INTO City(id,state_id,code,name) VALUES (430,30,'pingdingshan','固原');
INSERT INTO City(id,state_id,code,name) VALUES (431,30,'anyang','中卫');

--新疆
INSERT INTO City(id,state_id,code,name) VALUES (432,31,'zhengzhou','乌鲁木齐');
INSERT INTO City(id,state_id,code,name) VALUES (433,31,'kaifeng','克拉玛依');
INSERT INTO City(id,state_id,code,name) VALUES (434,31,'luoyang','吐鲁番');
INSERT INTO City(id,state_id,code,name) VALUES (435,31,'pingdingshan','哈密');
INSERT INTO City(id,state_id,code,name) VALUES (436,31,'anyang','昌吉');
INSERT INTO City(id,state_id,code,name) VALUES (437,31,'zhengzhou','博尔塔拉');
INSERT INTO City(id,state_id,code,name) VALUES (438,31,'kaifeng','巴音郭楞');
INSERT INTO City(id,state_id,code,name) VALUES (439,31,'luoyang','阿克苏');
INSERT INTO City(id,state_id,code,name) VALUES (440,31,'pingdingshan','克孜勒苏');
INSERT INTO City(id,state_id,code,name) VALUES (441,31,'anyang','喀什');
INSERT INTO City(id,state_id,code,name) VALUES (442,31,'zhengzhou','和田');
INSERT INTO City(id,state_id,code,name) VALUES (443,31,'kaifeng','伊犁');
INSERT INTO City(id,state_id,code,name) VALUES (444,31,'luoyang','塔城');
INSERT INTO City(id,state_id,code,name) VALUES (445,31,'pingdingshan','阿勒泰');
INSERT INTO City(id,state_id,code,name) VALUES (446,31,'anyang','石河子');
INSERT INTO City(id,state_id,code,name) VALUES (447,31,'zhengzhou','阿拉尔');
INSERT INTO City(id,state_id,code,name) VALUES (448,31,'kaifeng','图木舒克');
INSERT INTO City(id,state_id,code,name) VALUES (449,31,'luoyang','五家渠');
INSERT INTO City(id,state_id,code,name) VALUES (450,31,'pingdingshan','北屯');

--台湾
INSERT INTO City(id,state_id,code,name) VALUES (451,32,'zhengzhou','台北市');
INSERT INTO City(id,state_id,code,name) VALUES (452,32,'kaifeng','高雄市');
INSERT INTO City(id,state_id,code,name) VALUES (453,32,'luoyang','基隆市');
INSERT INTO City(id,state_id,code,name) VALUES (454,32,'pingdingshan','台中市');
INSERT INTO City(id,state_id,code,name) VALUES (455,32,'anyang','台南市');
INSERT INTO City(id,state_id,code,name) VALUES (456,32,'zhengzhou','新竹市');
INSERT INTO City(id,state_id,code,name) VALUES (457,32,'kaifeng','嘉义市');
INSERT INTO City(id,state_id,code,name) VALUES (458,32,'luoyang','台北县');
INSERT INTO City(id,state_id,code,name) VALUES (459,32,'pingdingshan','宜兰县');
INSERT INTO City(id,state_id,code,name) VALUES (460,32,'anyang','桃园县');
INSERT INTO City(id,state_id,code,name) VALUES (461,32,'zhengzhou','新竹县');
INSERT INTO City(id,state_id,code,name) VALUES (462,32,'kaifeng','苗栗县');
INSERT INTO City(id,state_id,code,name) VALUES (463,32,'luoyang','台中县');
INSERT INTO City(id,state_id,code,name) VALUES (464,32,'pingdingshan','彰化县');
INSERT INTO City(id,state_id,code,name) VALUES (465,32,'anyang','南投县');
INSERT INTO City(id,state_id,code,name) VALUES (466,32,'zhengzhou','云林县');
INSERT INTO City(id,state_id,code,name) VALUES (467,32,'kaifeng','嘉义县');
INSERT INTO City(id,state_id,code,name) VALUES (468,32,'luoyang','台南县');
INSERT INTO City(id,state_id,code,name) VALUES (469,32,'pingdingshan','高雄县');
INSERT INTO City(id,state_id,code,name) VALUES (470,32,'zhengzhou','屏东县');
INSERT INTO City(id,state_id,code,name) VALUES (471,32,'kaifeng','台东县');
INSERT INTO City(id,state_id,code,name) VALUES (472,32,'luoyang','花莲县');
INSERT INTO City(id,state_id,code,name) VALUES (473,32,'pingdingshan','澎湖县');

--香港
INSERT INTO City(id,state_id,code,name) VALUES (474,33,'zhengzhou','中西区');
INSERT INTO City(id,state_id,code,name) VALUES (475,33,'kaifeng','东区');
INSERT INTO City(id,state_id,code,name) VALUES (476,33,'luoyang','九龙城区');
INSERT INTO City(id,state_id,code,name) VALUES (477,33,'pingdingshan','观塘区');
INSERT INTO City(id,state_id,code,name) VALUES (478,33,'anyang','南区');
INSERT INTO City(id,state_id,code,name) VALUES (479,33,'zhengzhou','深水埗区');
INSERT INTO City(id,state_id,code,name) VALUES (480,33,'kaifeng','黄大仙区');
INSERT INTO City(id,state_id,code,name) VALUES (481,33,'luoyang','湾仔区');
INSERT INTO City(id,state_id,code,name) VALUES (482,33,'pingdingshan','油尖旺区');
INSERT INTO City(id,state_id,code,name) VALUES (483,33,'anyang','离岛区');
INSERT INTO City(id,state_id,code,name) VALUES (484,33,'zhengzhou','葵青区');
INSERT INTO City(id,state_id,code,name) VALUES (485,33,'kaifeng','北区');
INSERT INTO City(id,state_id,code,name) VALUES (486,33,'luoyang','西贡区');
INSERT INTO City(id,state_id,code,name) VALUES (487,33,'pingdingshan','沙田区');
INSERT INTO City(id,state_id,code,name) VALUES (488,33,'anyang','屯门区');
INSERT INTO City(id,state_id,code,name) VALUES (489,33,'zhengzhou','大埔区');
INSERT INTO City(id,state_id,code,name) VALUES (490,33,'kaifeng','荃湾区');
INSERT INTO City(id,state_id,code,name) VALUES (491,33,'luoyang','元朗区');

--澳门
INSERT INTO City(id,state_id,code,name) VALUES (492,34,'zhengzhou','花地玛堂区');
INSERT INTO City(id,state_id,code,name) VALUES (493,34,'kaifeng','圣安多尼堂区');
INSERT INTO City(id,state_id,code,name) VALUES (494,34,'luoyang','大堂区');
INSERT INTO City(id,state_id,code,name) VALUES (495,34,'pingdingshan','望德堂区');
INSERT INTO City(id,state_id,code,name) VALUES (496,34,'anyang','风顺堂区');
INSERT INTO City(id,state_id,code,name) VALUES (497,34,'zhengzhou','氹仔');
INSERT INTO City(id,state_id,code,name) VALUES (498,34,'zhengzhou','路环');


INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (1,'年假','Annual Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (2,'病假（不扣薪资）','Sick Leave (Full Pay)',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (3,'病假（扣薪资）','Sick Leave)',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (4,'事假','Compassionate Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (5,'婚假','Marriage Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (6,'婚假（晚婚）','Late Marriage Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (7,'产假','Maternity Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (8,'陪产假','Paternity Leave',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (9,'换休假','Off-in-lieu',0);
INSERT INTO Leave_Type (id,name,foreign_name,surplus_leave_strategy) VALUES (10,'工伤休假','On Job Injury Leave',0);

INSERT INTO Leave_Type_Strategy(id,type_id,base_days,increase_days_per_year,max_days) VALUES (1,1,15,1,20);
INSERT INTO Leave_Type_Strategy(id,type_id,base_days,increase_days_per_year,max_days) VALUES (2,3,15,1,20);

--INSERT INTO Work_Hours (id,morning_Start,moring_End,afternoon_Start,afternoon_End) VALUES (1,date,12,13,18);
INSERT INTO Work_Day (id,monday,tuesday,wednesday,thursday,friday,saturday,sunday) VALUES (1,1,1,1,1,1,0,0);


