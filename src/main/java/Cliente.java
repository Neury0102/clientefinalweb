import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.imageio.ImageIO;

public class Cliente {
    public static MensajeServidor initClient(String marca, String anio, String cantidadp, String tipocombustible, String precio, String tipo, String modelo, String uso, String cantidadc, String tipotransmision, String duracionp, String observacion, File[] pic) throws ClientProtocolException, IOException {

        HttpClient client = new DefaultHttpClient();

        MultipartEntityBuilder me = MultipartEntityBuilder
                .create()
                .addTextBody("marca", marca)
                .addTextBody("anio", anio)
                .addTextBody("pasajeros", cantidadp)
                .addTextBody("combustible", tipocombustible)
                .addTextBody("precio", precio)
                .addTextBody("tipo", tipo)
                .addTextBody("modelo", modelo)
                .addTextBody("uso", uso)
                .addTextBody("cilindros", cantidadc)
                .addTextBody("transmision", tipotransmision)
                .addTextBody("dias", duracionp)
                .addTextBody("usuario",Main.usuario.getUsername())
                .addTextBody("observaciones", observacion);


        for(File f : pic){
            me.addBinaryBody("upfile", f, ContentType.create("application/octet-stream"), f.getName());
        }
        HttpEntity entity = me.build();

        HttpPost httpPost = new HttpPost("http://localhost:4567/restServices/crearPublicacion");
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        String mensaje = "";

        while ((line = rd.readLine()) != null) {
            mensaje += line;
        }
        System.out.print(mensaje);
        Gson gson = new Gson();
        MensajeServidor ms = gson.fromJson(mensaje, MensajeServidor.class);
        return ms;


    }

    public Marca[] getMarcas() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:4567/restServices/marcas");
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        String mensaje = "";

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            mensaje += line;
        }

        Gson gson = new Gson();
        Marca[] marca = gson.fromJson(mensaje, Marca[].class);

        return marca;


    }

    public PublicacionInfo[] getPublicaciones() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:4567/restServices/publicaciones");
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        String mensaje = "";

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            mensaje += line;
        }
        Gson gson = new Gson();
        PublicacionInfo[] pi = gson.fromJson(mensaje,PublicacionInfo[].class) ;
        System.out.print(mensaje);
        return pi;


    }

    public Usuario autenticar(String usuario, String pass) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:4567/restServices/autenticar/" + usuario + "/" + pass);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        String json = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            json += line;
        }
        Gson gson = new Gson();
        Usuario usr = gson.fromJson(json,Usuario.class);

        return usr;

    }

    public Tipo[] getTipos() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:4567/restServices/tipos");
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        String mensaje = "";

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            mensaje += line;
        }

        Gson gson = new Gson();

        Tipo[] tipos = gson.fromJson(mensaje, Tipo[].class);

        return tipos;


    }

    public class Tipo {
        private String id;
        private String nombre;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String toString(){
            return this.nombre;
        }
    }

    public class UsuarioInfo{
        private String nombre;
        private String telefono;
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
    }

    public class PublicacionInfo{
        private UsuarioInfo vendedor;
        private String marca;
        private String modelo;
        private Integer anio;
        private Double precio;
        private List<String> imagenes = new ArrayList<>();

        public UsuarioInfo getVendedor() {
            return vendedor;
        }

        public void setVendedor(UsuarioInfo vendedor) {
            this.vendedor = vendedor;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public Integer getAnio() {
            return anio;
        }

        public void setAnio(Integer anio) {
            this.anio = anio;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public List<String> getImagenes() {
            return imagenes;
        }

        public void setImagenes(List<String> imagenes) {
            this.imagenes = imagenes;
        }

        public String toString(){
            return marca + " "  + modelo + " " + anio;
        }
    }

    public class Marca {
        private String id;
        private String nombre;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String toString(){
            return this.nombre;
        }
    }

    public class MensajeServidor{
        private String codigo;
        private String mensaje;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }

    public class Usuario{
        private String codigo;
        private String mensaje;
        private String publica;
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getPublica() {
            return publica;
        }

        public void setPublica(String publica) {
            this.publica = publica;
        }
    }
}


