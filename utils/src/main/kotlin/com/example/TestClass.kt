package com.example

data class TestClass(
    val name: String = "MainKt",
    val classPackage: String? = null,
    val fields: List<String> = emptyList(),
) {
    fun getFullName() = classPackage?.let {
        "$it.$name"
    } ?: name

    fun getJavaClass(): Class<*> {
        val clazz = this.findClassSafe()
        assert(clazz != null)
        return clazz!!
    }
}

fun TestClass.findClass(): Class<*> = Class.forName(this.getFullName())

fun TestClass.findClassSafe() = try {
    this.findClass()
} catch (e: ClassNotFoundException) {
    null
}

fun Class<*>.getDeclaredFieldsWithoutCompanion() = this.declaredFields.filter { it.name != "Companion" }