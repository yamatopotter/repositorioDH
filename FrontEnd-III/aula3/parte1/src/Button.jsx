function Button(props){
    function helloWorld(){
        alert("Hello world!");
      }

    return <button onClick={props.click} className={props.classes}>{props.name}</button>
}

export default Button;