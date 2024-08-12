def ceaserEncrypt(text: String, shift: Int): String  = {
    text.map((c)=> {
        if(c.isUpper) 
            ((c-65 + shift) % 26 + 65).toChar
        else if(c.isLower) 
            ((c-97 + shift) % 26 + 97).toChar
        else
            c
    })
} 

def ceaserDecrypt(text: String, shift: Int): String  = {
    text.map((c)=> {
        if(c.isUpper) 
            ((c-65 - shift) % 26 + 65).toChar
        else if(c.isLower) 
            ((c-97 - shift + 26) % 26 + 97).toChar
        else
            c
    })
} 

def cipher(text: String, shift: Int, mode: String, 
           encryptFunc: (String, Int) => String = ceaserEncrypt, 
           decryptFunc: (String, Int) => String = ceaserDecrypt, 
           ): String = {
  
  mode.toLowerCase match {
    case "encrypt" => encryptFunc(text, shift)
    case "decrypt" => decryptFunc(text, shift)
    case _         => throw new IllegalArgumentException("Mode should be 'encrypt' or 'decrypt'")
  }
}


@main def main() = {
    println(cipher("Hello World", 2, "encrypt"))
    println(cipher("abcdefghijklmnopqrstuvwxyz", 2, "encrypt"))
    println(cipher("abcdefghijklmnopqrstuvwxyz", 2, "decrypt"))
}