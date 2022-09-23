# KMMTest
Додаток для демонстрації роботи КММ під десктоп та андроїд

## Використані технології
- [Compose для UI слою](https://developer.android.com/jetpack/compose)
- [Ktor для роботи з АПІ запитами](https://ktor.io/)
- [Sqldelight для роботи з базою](https://cashapp.github.io/sqldelight/)
- [Kotlinx-serialization для серіалізації данних](https://kotlinlang.org/docs/serialization.html#example-json-serialization)
- [Koin - DI](https://insert-koin.io/)

## Результат
Вдалося розробити додаток з функціоналом отримання та збереження списка полів з повністю універсальним data слоєм та розшареним UI слоєм.
* Для функціонування додатка, потрібно встановити токен авторизації в классі `FieldsApi`
``const val TOKEN = "TOKEN"`` 
