
package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Criptografia {
    public String criptografar(char[] dado) throws Exception {
        try {
            MessageDigest cript = MessageDigest.getInstance("SHA-512");
            String sal = "Funeraria67M0gaddorSantaÉNossaAlegria_d@Silva__fs#@!%$LuziaSuaMortehgcxsa";
            
            // Pega os bytes do sal e insere juntamente com os bytes da criptografia
            // Usa o UTF_8 nativo para não ter dor de cabeça com acentuação no sal
            cript.update(sal.getBytes(StandardCharsets.UTF_8));
            
            /* 
                Cria uma lista de bytes a partir a digestão da criptografia pegando os bytes do dado
                Muda o Arrays.toString para um objeto de string diretamente e usa os Charsets padronizados
                para suportar acentuações (UTF-8)
            */ 
            byte[] nova = cript.digest(new String(dado).getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            
            // Transforma os números e traduz para hexadecimal
            for(byte b : nova) {
                builder.append(String.format("%02X", b & 0xFF));
            }
           
            // Retorna direto a string formatada lá dentro do for
            return  builder.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            throw new Exception("[CRIPTOGRAFIA] Algoritimo não encontrado: " + e.getMessage());
        }
    }
}
