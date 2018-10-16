import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.SuffixFileFilter
import org.jahia.fixapplier.controller.FixApplierController
import org.jahia.fixapplier.model.FixApplierDataModel
import org.jahia.fixapplier.tools.BundleUtils
import org.jahia.fixapplier.tools.FileLocation
import org.jahia.fixapplier.tools.JahiaPropertiesUtils

BundleUtils.clearBundleCache(fixApplierController, true);

updateJahiaProperties(fixApplierController);

FileUtils.touch(new File(fixApplierController.getDataDir(), "[generated-resources].dodelete"));

fixApplierController.out("\nAfter fix Groovy script executed successfully.\n");

private void updateJahiaProperties(FixApplierController fixApplierController) throws Exception {
    JahiaPropertiesUtils.addEntry(
            "jahia.ui.theme",
            "default",
            "\n######################################################################\n" +
            "### GWT THEME ACTIVATION #############################################\n" +
            "######################################################################\n" +
            "# Enable or disable new theme for GWT UI",
            null,
            "A new property was introduced with this version to configure the UI theme in edit and administration modes\n" +
            "Please manually add the following line into your jahia.properties file to preserve the old theme:\n" +
            "jahia.ui.theme = default",
            fixApplierController);

    JahiaPropertiesUtils.addEntry(
            "jahia.ui.dragAndDrop",
            "ENABLED",
            "######################################################################\n" +
            "### DRAG AND DROP CUSTOMIZATION #############################################\n" +
            "######################################################################\n" +
            "# this parameter change the drag behavior in edit mode\n" +
            "# - ENABLED (default): the entire content is draggable\n" +
            "# - NO_DRAG_IN_EDIT_AREA: dragging in the main panel is disabled, content can still be dropped from the side panel\n" +
            "# - DRAG_ZONE_IN_EDIT_AREA: a drag zone is displayed at the top left of the module. Only clicking in this drag zone\n" +
            "#   allows to drag the content\n" +
            "# - DISABLED: all the drag and drop is disabled",
            null,
            "A new property was introduced with this version to configure the drag and drop behavior in edit mode\n" +
            "Please manually add the following line into your jahia.properties file:\n" +
            "jahia.ui.dragAndDrop = ENABLED",
            fixApplierController);
}