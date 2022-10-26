function Container({children}){
    if(children){
        return (
            <div>
                {children}
            </div>
        )
    }
}

export default Container;