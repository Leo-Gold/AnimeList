команда maven:

**./mvnw** + postfix

*********
по умолчанию postfix:

- **validate**: проверьте правильность проекта и наличие всей необходимой информации
- **compile**: скомпилировать исходный код проекта
- **test**: протестируйте скомпилированный исходный код, используя подходящую платформу модульного тестирования. Эти тесты не должны требовать, чтобы код был упакован или развернут
- **package**: Скомпилировать код и упаковать его в распространяемый формат, например в JAR.
- **integration-test**: обработайте и при необходимости разверните пакет в среде, где можно запускать интеграционные тесты
- **verify**: выполните все проверки, чтобы убедиться, что упаковка действительна и соответствует критериям качества
- **install**: установите пакет в локальный репозиторий для использования в качестве зависимости в других проектах локальное
- **deploy**:  выполняется в среде интеграции или выпуска, копирует окончательный пакет в удаленный репозиторий для совместного использования с другими разработчиками и проектами.
Помимо приведенного выше списка по умолчанию, следует отметить два других жизненных цикла Maven. Они являются

- **clean**: очищает артефакты, созданные предыдущими сборками
- **site**: создает документацию сайта для этого проекта

*********
комманда spring postfix:
- **spring-boot:run** : запуск spring приложения
