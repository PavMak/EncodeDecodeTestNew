package com.example.encodedecodetest

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Base64
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.nio.charset.StandardCharsets
import java.security.Key
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import javax.crypto.Cipher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val (repository) = this.dependencies()
        /*String text = "Привет, это мое первое зашифрованное сообщение";
        TextView originalMessageView = findViewById(R.id.originalMessage);
        originalMessageView.setText(text);

        RSAPrivateKey keyPrivate = null;

        String privateKeyTest = "MIIEpAIBAAKCAQEAtXdqVittGjrt2TG4Nopd030M/hHUy6LmkHNDObBIcTORq2tqG7JSvrheeK8amhK39BJ6D+FSjdyFSYnyfJuhJeJTiibI6gokdv4qCW36OFC8CMGwIe7+uVI8Vn3b7/4gXKbx6aGqgjx22G6k7Z0gmT7o0URCcGio0w1L1RNaaO9bBCJyHGO1LkcOxdY5V5DsmdqTUG/SCZcAeeu057ylZNCqfqFuH/mKK1XRqtIUU6dl89YL3qN185tXgy9idn0MiDVyMRI+hZo31Dgkv4sehE0eWPV83scTCWUVxs3khL29KPcjLIaX+0ocyVyu/4+LtOJuqCLemhJSUqoGlswvKQIDAQABAoIBAE7m0soPzLr0d3mSCD5SsFQmEdGg0C0Qsf6J12eMchsiaIqnxDWxtg+uG4mO3Vqzm99Yb1FbT+lVwnCEtfYfNxTBUUCG96Hncg55Ga8K7hqxY+jMyrgecgwDKTAUPl6d2NVgU1wZyokhIC2gAj88rDFlrJZc/yRgJVPK+rd1WEC6YGqKxbVh3njkYlDORsX8s+ODMCHQs2O9HE6JKjjqJccc0UwcFfOk51wwq0pbYfh11b1+7oUOwc66JzCo6ePxHX4w1phaMd/8eMrEPlh3OMrFBpU7lhYdCiupXBVwmZ1cc8G9TbydRerUGrgrT0RxT/9V4YOtRLpZToI4C7SliRcCgYEA+1jdJqLdk6480KiXKdwhmrgsIpFFgqMPXpdHeU4O/+G+55ruvqJPwi23gQfn9BABDj27MXW+aX2fDGghNeKBBEbkFINUEJv3D8JdMhzaommSQth9JQxrcZZZEwhHeokFOPwMngNUmjac+L4QBU/9IgH1AIXe5erN5SwBU+R4B1cCgYEAuNNi8HnEDI1Ju/sqSNipJUrsHQjziukFRX1FsXRdbYNelnOMgOTZStp8mUME5SEaofEvkLqFDFb5OePH+UNy0U+/WTP35hElMhNdPpHgHpUVO2cCHexfxQmGy63r0/Y/vZOBxLWHHiG7KgivVVMxy91Jmyo9m3HG355rA/MT7X8CgYEAtREzX938GaNvlDGflDxMyRTcVpqopI+rRs1cY/rju1p5GIf4bcSoCI6+n2l+o8fTutqlu9/CqGQi6+En65Wcs+QN8ukY6k4xEV1Hng5DQrUi9JzYqpPj4xQYXymbtJ548LBCtqJXlDC7rEXfbLRO+uzF/vZxuNgKM4ob+r+f6EkCgYAZQTEkwM6sFGY93G0DtS8vnFQ1B3MXyQ1iWGK8g7T8cNXs4u8Q8bRLSR17Z6/0ixhzhlxEf2gMrpmxclFx2uiGd0ojKzm1YyRc+k5kbVRdeWuESWf9pL3VU57ql+JAfUZqZgx2T4Od92f2r2cd1pdYTu1u2U+/vMU66w+eY4mWiwKBgQCT2fcA8+1NmvOxMdrgWQP3iHZHnelkeyPgta7eiW5rwDvsgF4pOp4m43z+fdxJ/9Baw5edixsxkmlkqIM+6pjOW/ct2YavTRYPXB7nuf6Q74PhjlCB+p2r3Ust6FyqmdBjG+E5TvzQ1MhHI1aMEQVx5+hkNT+LknmcDxBYrpPhpg==";
        byte[] keyBytes = Base64.decode(privateKeyTest, Base64.DEFAULT);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            keyPrivate = (RSAPrivateKey)factory.generatePrivate(spec);
        } catch (Exception e) {
            Log.e("CryptoError", "SomeError", e);
        }*/


        try {
            val generator = KeyPairGenerator.getInstance("RSA")
            generator.initialize(2048)
            val pair = generator.genKeyPair()
            //publicKey = pair.public
            repository.setPublicKey(Base64.encodeToString(pair.public.encoded, Base64.NO_WRAP))
            //println(Base64.encodeToString(publicKey.getEncoded(), Base64.NO_WRAP))
            //privateKey = pair.private
            repository.setPrivateKey(Base64.encodeToString(pair.private.encoded, Base64.NO_WRAP))
        } catch (e: Exception) {
            Log.e("CryptoError", "SomeError", e)
        }
        /*byte[] encodeBytes = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            encodeBytes = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            Log.e("CryptoError", "SomeError", e);
        }*/
        /*val encodeMessage = "TcIc/FABF42Xc86edeh6+HRnlUusMiaF7y6P7ZHhL5lQN6Yz51LNgk2HPcYUIGoK/7d6lnTG1YRctt1z3qUpJVlFMtyM4UqIAR908JKkHYlpVQSC6CU3e8FwUugaq3Mfd1b2q8ef1oG1P9dZ9YWjSAxKqo/i/9KXVi6aWD9dRy866BmuH0UiMYCuQ0Z/C402Tb8KS8XFxdPjtVQTP6hL6YZXZnSXz8Xlpkbw5H9x795FjpkN43CiDP6MqjHQiHPgGNqMwj42zTjQrz1WhTVXu5KC010mpVKZ4558eKIld/qLDa8FvSfthskvkIokxohr8DTLieD8ojoLUIoHFCEW6Q=="
        val encodeBytes = Base64.decode(encodeMessage.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT)
        println(encodeBytes.size)
        val encodeMessageView = findViewById<TextView>(R.id.encodeMessage)
        encodeMessageView.text = Base64.encodeToString(encodeBytes, Base64.DEFAULT)*/

        println(repository.getPrivateKey())
        println(repository.getPublicKey())

        val keyBytes = Base64.decode(repository.getPrivateKey(), Base64.DEFAULT)
        val spec = PKCS8EncodedKeySpec(keyBytes)

        val factory = KeyFactory.getInstance("RSA")
        val keyPrivate = factory.generatePrivate(spec) as RSAPrivateKey

        /*var decodeBytes: ByteArray? = null
        try {

            val decodeCipher = Cipher.getInstance("RSA/ECB/OAEPPadding")
            decodeCipher.init(Cipher.DECRYPT_MODE, keyPrivate)
            decodeBytes = decodeCipher.doFinal(encodeBytes)
            println(decodeBytes.size)
        } catch (e: Exception) {
            Log.e("CryptoError", "SomeError", e)
        }
        val decodeMessageView = findViewById<TextView>(R.id.decodeMessage)
        decodeMessageView.text = String(decodeBytes!!)*/
    }
}