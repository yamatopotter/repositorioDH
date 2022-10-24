// function botaoLike(){
//     return React.createElement(
//         'button',
//         {
//             onClick: () => { alert("Botão OK")},
//             style: {
//                 backgroundColor: "red"
//             },
//         },
//         "Pressione"
//     )
// }

// const domContainer = document.querySelector("like_button_container");
// const domRoot = ReactDOM.createRoot(domContainer);

// domRoot.render(botaoLike);

function MeuComponente() { 
    return React.createElement( 
        "button",
         { 
            onClick: () => alert("ok"),
            style: { backgroundColor: "red", },
         },
         "Pressione" ); 
}

const domContainer = document.querySelector("#like_button_container");
const root = ReactDOM.createRoot(domContainer); 
root.render(MeuComponente()); 