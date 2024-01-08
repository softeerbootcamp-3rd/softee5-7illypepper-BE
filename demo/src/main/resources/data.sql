INSERT INTO category (category_id, name) values (1, '문학');
INSERT INTO category (category_id, name) values (2, '음악');
INSERT INTO category (category_id, name) values (3, '역사');
INSERT INTO category (category_id, name) values (4, '영화');
INSERT INTO category (category_id, name) values (5, '예술');
INSERT INTO category (category_id, name) values (6, '디저트');
INSERT INTO category (category_id, name) values (7, '이색 메뉴');
INSERT INTO category (category_id, name) values (8, '숨은 맛집');
INSERT INTO category (category_id, name) values (9, '스포츠');
INSERT INTO category (category_id, name) values (10, '페스티벌');
INSERT INTO category (category_id, name) values (11, '공방');
INSERT INTO category (category_id, name) values (12, '체험');
INSERT INTO category (category_id, name) values (13, '공원');
INSERT INTO category (category_id, name) values (14, '풍경');
INSERT INTO category (category_id, name) values (15, '커뮤니티');
INSERT INTO category (category_id, name) values (16, '파티');

INSERT INTO theme (theme_id, name) values (1, '편안한');
INSERT INTO theme (theme_id, name) values (2, '조용한');
INSERT INTO theme (theme_id, name) values (3, '신나는');
INSERT INTO theme (theme_id, name) values (4, '커피향이 솔솔');
INSERT INTO theme (theme_id, name) values (5, '숲');
INSERT INTO theme (theme_id, name) values (6, '다른 사람들이 좋아한');


INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (15, '양재역', null, '양재역', 0, 127.034022, 37.484557);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (15, '힐튼 가든', null, '힐튼 가든 인 서울', 0, 127.0327635, 37.4858831);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (5, '에버모어 엔터테인먼트', null, '엔터테인먼트', 0, 127.03449720489127, 37.4860034618704);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (5, '아도바', null, '아도바', 0, 127.03083359101153, 37.48553144544011);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '던킨도넛', null, '던킨 양재역사점', 0, 127.034883, 37.4842959);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '투썸플레이스', null, '투썸플레이스 양재', 0, 127.0356598, 37.4824583);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '프릳츠', null, '프릳츠 양재점', 0, 127.0321832, 37.4853311);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, 'BREAD PAPAs', null, '제과제빵', 0, 127.0347191, 37.4840752);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '코나카페', null, '카페', 0, 127.0355534378676, 37.48398263746647);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '카페핸드메이드', null, '카페', 0, 127.03658188978969, 37.4830723048293);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '에이미스커피', null, '카페', 0, 127.03127994019968, 37.48488710714014);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '일생과일푸르츠', null, '카페', 0, 127.03239949626116, 37.48533730961639);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '원썸', null, '카페', 0, 127.03496072170815, 37.4858659218668);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '커피에스페란토', null, '카페', 0, 127.035642012737, 37.48598059685432);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (6, '카페253', null, '카페', 0, 127.03297078508234, 37.48601516030119);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '버거킹', null, '버거킹 양재점', 0, 127.0337427, 37.4840618);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '명동칼국수', null, '명동칼국수', 0, 127.0348679, 37.4848342);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '미가참치', null, '참치 전문점', 0, 127.03578528972862, 37.484124476312374);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '태국식당356', null, '태국 음식 전문점', 0, 127.03662196026048, 37.48409268464161);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '어거스트치킨', null, '치킨전문점', 0, 127.0349669, 37.484057);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (8, '메기대감', null, '메기 전문점', 0, 127.03610721251648, 37.48347114716664);
INSERT INTO place (category_id, name, thumbnail, content, rating, axisX, axisY) values (15, '올리브영', null, '올리브영', 0, 127.03618149968165, 37.48511996995919);


INSERT INTO route (name, length, estimated_time, rate_total, rate_count, axisX, axisY) values ('편안한 길', 300, 20, 0, 0, 127.0349669, 37.484057);
INSERT INTO route (name, length, estimated_time, rate_total, rate_count, axisX, axisY) values ('밝은 길', 400, 25, 0, 0, 127.0349669, 37.484057);
INSERT INTO route (name, length, estimated_time, rate_total, rate_count, axisX, axisY) values ('불편한 길', 300, 20, 0, 0, 127.0349669, 37.484057);
INSERT INTO route (name, length, estimated_time, rate_total, rate_count, axisX, axisY) values ('쉬운 길', 300, 20, 0, 0, 127.0349669, 37.484057);
INSERT INTO route (name, length, estimated_time, rate_total, rate_count, axisX, axisY) values ('복잡한 길', 300, 20, 0, 0, 127.0349669, 37.484057);
