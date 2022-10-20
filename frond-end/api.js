const api = {
    host: "http://localhost:8080",
    carregarProfissionais: async () => {
        const settings = {
            method: 'GET',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            }
        };
        try {
            const fetchResponse = await fetch(`${api.host}/profissionais`, settings);
            const profissionais = await fetchResponse.json();

            let html = ""
            profissionais.forEach(profissional => {
                html += `
                <tr>
                    <th scope="row">${profissional.id}</th>
                    <td>${profissional.nome}</td>
                    <td>${profissional.observacao}</td>
                    <td>${profissional.dataCriacao}</td>
                    <td class="table-action"><a href="#formCadastro" class="btn btn-warning" onclick="api.alterarProfissionalTela(${profissional.id})">Alterar</a></td>
                    <td class="table-action"><button class="btn btn-danger" onclick="api.excluirFuncionario(${profissional.id})">Excluir</button></td>
                </tr>
                `
            });

            document.getElementById("registros").innerHTML = html;

        } catch (e) {
            console.log(e);
        } 
    },
    cadastrarProfissionais: async (e) => {
        e.preventDefault();

        let id = document.getElementById("id").value;
        let nome = document.getElementById("nome").value;
        let observacao = document.getElementById("observacao").value;

        if(nome == ""){
            alert("Nome obrigatório");
            document.getElementById("nome").focus();
            return;
        }

        let profissional = {
            nome: nome,
            observacao: observacao
        };

        let settings = {};
        let url = "";

        if(id == ""){
            url = `${api.host}/profissionais`;
            settings = {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(profissional)
            };
        }
        else{
            url = `${api.host}/profissionais/${id}`;
            settings = {
                method: 'PUT',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(profissional)
            };
        }


        try {
            await fetch(url, settings);
            api.carregarProfissionais();
        } catch (e) {
            console.log(e);
        } 

        document.getElementById("id").value = "";
        document.getElementById("nome").value = "";
        document.getElementById("observacao").value = "";
    },
    excluirFuncionario: async (id) => {
        if(confirm("Confirma?")){
            const settings = {
                method: 'DELETE',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                }
            };
            try {
                await fetch(`${api.host}/profissionais/${id}`, settings);
                api.carregarProfissionais();
            } catch (e) {
                console.log(e);
            } 
        }
    },
    alterarProfissionalTela: async (id) => {
        const settings = {
            method: 'GET',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            }
        };
        try {
            const fetchResponse = await fetch(`${api.host}/profissionais/${id}`, settings);
            const profissional = await fetchResponse.json();

            document.getElementById("id").value = profissional.id;
            document.getElementById("nome").value = profissional.nome;
            document.getElementById("observacao").value = profissional.observacao;

        } catch (e) {
            console.log(e);
        } 
    }
}


api.carregarProfissionais();