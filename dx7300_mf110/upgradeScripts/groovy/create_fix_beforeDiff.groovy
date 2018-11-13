import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import org.apache.commons.io.FileUtils;

// Copy ldap to modules
File ldapTarget = new File(patchedWebappDirectory, "../../../digital-factory-data/modules/ldap-3.1.2.jar").getCanonicalFile();
FileUtils.copyURLToFile(new URL("https://devtools.jahia.com/nexus/content/repositories/jahia-releases/org/jahia/modules/ldap/3.1.2/ldap-3.1.2.jar"), ldapTarget);
fixCreatorController.out("Downloaded ldap to " + ldapTarget);

// Copy remotepublish to modules
File remotepublishTarget = new File(patchedWebappDirectory, "../../../digital-factory-data/modules/remotepublish-8.1.2.jar").getCanonicalFile();
Authenticator.setDefault(new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("jahia", "kr5vdn2z".toCharArray());
    }
});
FileUtils.copyURLToFile(new URL("https://devtools.jahia.com/nexus/content/repositories/jahia-enterprise-releases/org/jahia/modules/remotepublish/8.1.2/remotepublish-8.1.2.jar"), remotepublishTarget);
fixCreatorController.out("Downloaded remotepublish to " + remotepublishTarget);

// Move jahia-impl-7.2.2.0.jar into a temp folder
FileUtils.moveToDirectory(new File(patchedWebappDirectory, "WEB-INF/lib/jahia-impl-7.2.2.0.jar"), FileUtils.getTempDirectory(), true);
// Copy patched jahia-impl-7.2.2.0-01.jar
File jahiaImplTarget = new File(patchedWebappDirectory, "WEB-INF/lib/jahia-impl-7.2.2.0-01.jar");
FileUtils.copyURLToFile(new URL("https://devtools.jahia.com/nexus/content/groups/public/org/jahia/server/jahia-impl/7.2.2.0-01/jahia-impl-7.2.2.0-01.jar"), jahiaImplTarget);
fixCreatorController.out("Downloaded jahia-impl to " + jahiaImplTarget);
