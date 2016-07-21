import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
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

public class Cliente {
    public static void initClient(String marca, String anio, String cantidadp, String tipocombustible, String precio, String tipo, String modelo, String uso, String cantidadc, String tipotransmision, String duracionp, String observacion, File[] pic) throws ClientProtocolException, IOException {

        HttpClient client = new DefaultHttpClient();


        MultipartEntityBuilder me = MultipartEntityBuilder
                .create()
                // .addTextBody("number", pic)
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
                .addTextBody("observaciones", observacion);


        for(File f : pic){
            me.addBinaryBody("upfile", f, ContentType.create("application/octet-stream"), f.getName());
        }
        HttpEntity entity = me.build();

        HttpPost httpPost = new HttpPost("http://192.168.1.18:4567/restServices/crearPublicacion");
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        HttpEntity result = response.getEntity();
    }

    public ArrayList<String> getMarcas() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.1.18:4567/restServices/marcas");
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
        ArrayList<String> ret = new ArrayList<String>();
        Marca[] marca = gson.fromJson(mensaje, Marca[].class);
        for (Marca m : marca) {
            ret.add(m.getNombre());
        }
        return ret;


    }

    public ArrayList<String> getTipos() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.1.18:4567/restServices/tipos");
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
        ArrayList<String> ret = new ArrayList<String>();
        Tipo[] tipos = gson.fromJson(mensaje, Tipo[].class);
        for (Tipo m : tipos) {
            ret.add(m.getNombre());
        }
        return ret;


    }

    private class Tipo {
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
    }

    private class Marca {
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
    }
}


