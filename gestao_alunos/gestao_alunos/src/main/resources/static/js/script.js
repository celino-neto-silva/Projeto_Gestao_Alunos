document.addEventListener("DOMContentLoaded", () => {
    const btnsRemover = document.querySelectorAll(".btn-remover");

    btnsRemover.forEach(btn => {
        btn.addEventListener("click", (event) => {
            const confirmacao = confirm("Tem a certeza que deseja remover este aluno?");
            if(!confirmacao){
                event.preventDefault();
            }
        })
    });

    console.log("Script JS carregado com sucesso!");
});