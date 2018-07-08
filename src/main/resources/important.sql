drop table if exists article;

create table article (aID BIGINT primary key auto_increment, title varchar, url varchar, allCharNum INT, chineseCharNum INT, englishCharNum INT, symbolCharNum INT);
