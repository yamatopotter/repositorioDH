export function isHexaValido(cor) {
    const regexColor = /^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$/;

    return regexColor.test(cor);
}

function fetchImg(configuracaoFetch) {
    return fetch('https://source.unsplash.com/1600x900/', configuracaoFetch);
}

export async function getImgBackground(){
    const configuracaoFetch = {
        method: 'GET'
    }

    const serverResponse = await fetchImg(configuracaoFetch);
    const imgData = await serverResponse.url;
    const serverStatus = await serverResponse.status;

    if (serverStatus==200){
        setSystemBackgroundImage(imgData);
        return imgData;
    }else if(serverStatus == 404){
        alert('Oops, houve um erro')
    }else{
        alert('Oops, houve um erro: Houve um erro ao carregar as informações do usuário, mas isso não impede o funcionamento do app')
    }
}

export function setSystemBackgroundImage(url){
    document.body.style.background=`url(${url}) no-repeat center center/cover`;
}
