Во время разработки данного проекта возникали определенные проблемы, решением которых было применение того или иного паттерна 
проектирования. Паттерн - часто встречающееся решение определенной проблемы при проектировании архитектуры проекта.

### Singleton
Одиночка (Singleton, Синглтон) — это порождающий паттерн проектирования, который гарантирует, что у класса есть только один экземпляр, и 
предоставляет к нему глобальную точку доступа. В качестве такого класса в данном проекте используется класс MyGdxGame, наследуемый от Game.
Класс Game — это реализация интерфейса ApplicationListener, данный класс будет интерфейсом между нашим кодом и платформо-зависимым 
приложением, которое будет запускаться непосредственно на устройстве. Ниже представлены пример диаграммы классов и код проекта.

![SingletonDiagram](https://github.com/IamKPOLLI/Math-Battle/blob/master/Patterns/Singleton_Diagram.png)

![SingletonDiagram](https://github.com/IamKPOLLI/Math-Battle/blob/master/Patterns/Singleton.png)

### Adapter
В проекте присутствует статистика, которая должна храниться в файле. Однако то, как она хранится в файле, существенно отличается от того, 
как ее должен видеть пользователь. Для этого был создан класс Info, который адаптирует данные, лежащие в файле к виду, который бы 
воспринимал пользователь.
Адаптер — это структурный паттерн проектирования, который позволяет объектам с несовместимыми интерфейсами работать вместе.  
В данном проете обьектом-адаптером является класс Info. Ниже представлены пример диаграммы классов и код проекта.

![Adapter](https://github.com/IamKPOLLI/Math-Battle/blob/master/Patterns/Adapter_Diagram.png)

![Adapter](https://github.com/IamKPOLLI/Math-Battle/blob/master/Patterns/Adapter1.png)

![Adapter](https://github.com/IamKPOLLI/Math-Battle/blob/master/Patterns/Adapter2.png)