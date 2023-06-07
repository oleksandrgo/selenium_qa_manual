# selenium_qa_manual
Цей проєкт створений для того щоб показувати студентам приклади з різного типу автотестів:
1. UI
2. BDD
3. API 
4. Unit

Тесты можна запускати як з самого класу, а також можна запускати зі сюта. 
Для того щоб запустити тести зі сюта необхідно виконати наступні команди в консолі
1. UI - mvn clean test -Dfilename=uiSuit.xml
2. API - mvn clean test -Dfilename=apiSuit.xml
3. Unit - mvn clean test -Dfilename=unitSuit.xml
4. BDD - mvn clean test -Dfilename=BDD.xml
Для того щоб запустити з класу просто натискайте RUN і все.

Все що ван необхідно це встановити 
1. JAVA версія 11 та вище
2. Maven останню версію. Якщо в вас вже є Maven спробуйте зі своєю версію, повинен працювати
3. Для запуску BDD тестів встановіть Cucumber+ та Cucumber for Java