package com.random.encryption;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Encryption {

    public static void encryptFile(String pubKeyPath, String inputFile) throws Exception {
        PublicKey publicKey = RsaEnc.loadPublic(pubKeyPath);
        try (FileInputStream in = new FileInputStream(inputFile);
             FileOutputStream out = new FileOutputStream(inputFile + ".enc")) {
            AesEnc.encryptFile(publicKey, in, out);
        }
    }

    public static void decrypFile(String privateKeyPath, String inputFile) throws Exception {
        PrivateKey privateKey = RsaEnc.loadPrivate(privateKeyPath);
        try (FileInputStream in = new FileInputStream(inputFile);
             FileOutputStream out = new FileOutputStream(inputFile + ".ver")) {
            AesEnc.decrypFile(privateKey, in, out);
        }
    }

//    public static void encryptFile(String pubKeyPath, String inputFile) throws Exception {
//        PublicKey publicKey = RsaEnc.loadPublic(pubKeyPath);
//        AesEnc.encryptFile(publicKey, inputFile);
//    }
//    public static void decrypFile(String privateKeyPath, String inputFile) throws Exception {
//        PrivateKey privateKey = RsaEnc.loadPrivate(privateKeyPath);
//        AesEnc.decrypFile(privateKey, inputFile);
//    }

}
