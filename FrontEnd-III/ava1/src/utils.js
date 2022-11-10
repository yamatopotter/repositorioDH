export function isHexaValido(cor) {
    const regexColor = /^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$/;

    return regexColor.test(cor);
}