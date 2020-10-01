package br.digital.com

fun main() {

    var dhmng = DigitalHouseManager()

    with(dhmng) {
        println("----- Registro dos professores -----")
        registrarProfessorTitular("Vishen", "Lakhiani", 1, "Personal growth")
        registrarProfessorTitular("Jim", "Kwik", 2, "Brain")
        registrarProfessorAdjunto("Jon", "Butcher", 3, 8)
        registrarProfessorAdjunto("Missy", "Butcher", 4, 6)

        println("\n----- Registro dos cursos -----")
        registrarCurso("Full Stack", 20001, 3)
        registrarCurso("Android", 20002, 2)

        println("\n----- Registro dos alunos -----")
        matricularAluno("Marina", "Saito", 1000)
        matricularAluno("Zé", "Silva", 1001)
        matricularAluno("Fulano", "de Tal", 1002)

        println("\n----- Alocação dos professores aos cursos -----")
        alocarProfessores(20001, 1, 3)
        alocarProfessores(20002, 2, 4)

        println("\n----- Matrícula dos alunos nos cursos -----")
        matricularAluno(1000, 20001)
        matricularAluno(1001, 20001)
        matricularAluno(1002, 20002)
        matricularAluno(1000, 20002)
        matricularAluno(1001, 20002)

        println("\n----- Consulta de cursos em que o aluno está matriculado -----")
        consultaMatricula(1000)
        consultaMatricula(1002)
        consultaMatricula(1005)

        println("\n----- Exclusão de curso -----")
        excluirCurso(20002)
        excluirCurso(20002)

        println("\n----- Exclusão de professor -----")
        excluirProfessor(3)
        excluirProfessor(3)

    }




}