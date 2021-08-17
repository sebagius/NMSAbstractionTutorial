package dev.agius.minecraft.abstraction;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.bukkit.Server;

import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class AbstractionLoader {

    private String implementationName;

    public void loadLocalAbstractions(Server server) {
        JsonParser parser = new JsonParser();
        JsonObject versions = parser.parse(new JsonReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                this.getClass().getClassLoader().getResourceAsStream("version_info.json")
                        )
                )
        )).getAsJsonObject();

        this.implementationName = versions.getAsJsonPrimitive(server.getVersion().substring(server.getVersion().indexOf("MC") + 4, server.getVersion().length() - 1)).getAsString();
    }

    public String getImplementationName() {
        return implementationName;
    }

    @SuppressWarnings("unchecked")
    public <T> T initiateObject(Class<T> clazz, Object... params) {
        String implementationClass = clazz.getSimpleName().substring(1) + "Impl";
        String implementationPackage = clazz.getPackage().getName() + "." + implementationName;

        try {
            Class<?> returnClass = getClass().getClassLoader().loadClass(implementationPackage + "." + implementationClass);

            if (!clazz.isAssignableFrom(returnClass)) {
                System.out.printf("%s does not implement %s%n", returnClass.getSimpleName(), clazz.getSimpleName());
                return null;
            }

            Class<?>[] paramsClasses = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramsClasses[i] = params[i].getClass();
            }

            Object instance = returnClass.getConstructor(paramsClasses).newInstance(params);

            return (T) instance;
        } catch (ClassNotFoundException e) {
            System.out.printf("Implementation of %s not found%n", clazz.getSimpleName());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.printf("Failed to invoke %s%n", clazz.getSimpleName());
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.printf("Failed to instantiate %s%n", clazz.getSimpleName());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.printf("Illegal access of %s%n", clazz.getSimpleName());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.printf("Constructor of %s not found%n", clazz.getSimpleName());
            e.printStackTrace();
        }
        return null;
    }
}
