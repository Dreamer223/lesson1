package ru.webapp.dreamer

import java.util.Scanner

fun main() {
    val contacts = mutableMapOf<String, MutableSet<String>>()
    val scanner = Scanner(System.`in`)

    while (true) {
        print("Введите команду (help для справки): ")
        val input = scanner.nextLine().split(" ")

        when (input[0]) {
            "exit" -> {
                println("Программа завершена.")
                break
            }
            "help" -> {
                println("Доступные команды:")
                println("exit - выход из программы")
                println("help - отображение справки")
                println("add <Имя> phone <Номер телефона> - добавить контакт с номером телефона")
                println("add <Имя> email <Адрес электронной почты> - добавить контакт с адресом электронной почты")
            }
            "add" -> {
                if (input.size < 4) {
                    println("Неверный формат команды.")
                    continue
                }
                val name = input[1]
                val type = input[2]
                val value = input[3]

                val contact = contacts.getOrPut(name) { mutableSetOf() }
                contact.add("$type: $value")
                println("Контакт добавлен: $name - $type: $value")
            }
            else -> println("Неизвестная команда. Введите 'help' для справки.")
        }
    }
}