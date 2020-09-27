package br.digital.com

fun main() {

    var dhmng = DigitalHouseManager()

    with(dhmng) {

        registrarProfessorTitular("Vishen", "Lakhiani", 1, "Personal growth")
        registrarProfessorTitular("Jim", "Kwik", 2, "Brain")
        registrarProfessorAdjunto("Jon", "Butcher", 3, 8)
        registrarProfessorAdjunto("Missy", "Butcher", 4, 6)

        registrarCurso("Full Stack", 20001, 3)
        registrarCurso("Android", 20002, 2)

        registrarAluno("Marina", "Saito", 1000)
        registrarAluno("Zé", "Silva", 1001)
        registrarAluno("Fulano", "de Tal", 1002)

        alocarProfessores(20001, 1, 3)
        alocarProfessores(20002, 2, 4)

        matricularAluno(1000, 20001)
        matricularAluno(1001, 20001)

        matricularAluno(1002, 20002)
        matricularAluno(1000, 20002)
        matricularAluno(1001, 20002)
    }

}