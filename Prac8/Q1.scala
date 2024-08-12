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

def Cipher(fx: (String, Int)=> String) = {
    fx
}


@main def main() = {
    println(ceaserDecrypt(ceaserEncrypt("Hello world", 1), 1))
    println(ceaserDecrypt(ceaserEncrypt("Hello world", 2), 2))
    println(ceaserDecrypt(ceaserEncrypt("abcdefghijklmnopqrstuvwxyz", 2), 2))
    ceaserDecrypt(ceaserEncrypt("abcdefghijklmnopqrstuvwxyz", 2), 2)
}