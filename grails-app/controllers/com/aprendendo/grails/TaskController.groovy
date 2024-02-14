package com.aprendendo.grails

import groovy.sql.Sql

class TaskController {

    def list() {
        render(view: "list")
    }

    def create() {
        render(view: "createForm")
    }

    def cadastrar(){

        def connection = getConnection()
        def sql = new Sql(connection)
        def insertQuery = "INSERT INTO apprh.pagamento (nome, valor) VALUES (?, ?)"

        //def nome = params.nome
        //def valor = params.valor

        def nome = "Lucas"
        def valor = 10.00

        try {
            sql.executeInsert(insertQuery, [nome, valor])
            println "Inserção realizada com sucesso"
        } catch (Exception e) {
            println "Erro ao inserir dados: ${e.message}"
        } finally {
            // Feche a conexão
            sql.close()
        }

        println "Nome: $nome, Valor: $valor"

        render "OK"
    }
}