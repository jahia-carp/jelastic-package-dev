import org.apache.commons.io.FileUtils

// Delete ldap from modules
FileUtils.deleteQuietly(new File(patchedWebappDirectory, "../../../digital-factory-data/modules/modules/ldap-3.1.2.jar"));
// Delete remotepublish from modules
FileUtils.deleteQuietly(new File(patchedWebappDirectory, "../../../digital-factory-data/modules/modules/remotepublish-8.1.2.jar"));

// Restore jahia-impl-7.2.2.0.jar from a temp folder
FileUtils.forceDelete(new File(patchedWebappDirectory, "WEB-INF/lib/jahia-impl-7.2.2.0-01.jar"));
FileUtils.moveToDirectory(new File(FileUtils.getTempDirectory(), "jahia-impl-7.2.2.0.jar"), new File(patchedWebappDirectory, "WEB-INF/lib"), true);
