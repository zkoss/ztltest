package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2127.zul")
class B65_ZK_2127Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
	<window>
		<zscript><![CDATA[
class SelectionModel{
            String ticketAuthorType = "CURRENT";
            selectedAuthorContact = null;

            public String getTicketAuthorType() {
                return ticketAuthorType;
            }

            public void setTicketAuthorType(String string) {
                ticketAuthorType = string;
            }

            public String getSelectedAuthorContact() {
                return selectedAuthorContact;
            }

            public void setSelectedAuthorContact(String string) {
                selectedAuthorContact = string;
            }

            public getContacts() {
                if("CURRENT".equals(ticketAuthorType)) {
                    return new String[]{};
                } else {
                    return new String[] {"Jean Dupont", "Jeanne Dupond"};
                }
            }
        }
	class MyClass {
		SelectionModel selectionModel = new SelectionModel();

		public SelectionModel getSelectionModel() {
			return selectionModel;
		}

		public isTicketAuthorContactDisabled() {
			return !"CONTACT".equals(selectionModel.ticketAuthorType);
		}

		public boolean getTicketAuthorContactDisabled() {
			return !"CONTACT".equals(selectionModel.ticketAuthorType);
		}
	}
	controller = new MyClass();
]]>
        </zscript>
        <div> Click 'CONTACT' then the combobox should be enable
        </div>
		<radiogroup id="ticketAuthorTypeField"
			selectedItem="@{controller.selectionModel.ticketAuthorType, save-when='self.onClick'}">

			<radio label="CURRENT:" value="CURRENT" />

			<radio label="CONTACT:" value="CONTACT" />

			<combobox id="authorContactField" sclass="koalyexpOptionL"
				autodrop="true" buttonVisible="false"
				model="@{controller.selectionModel.contacts, load-after='ticketAuthorTypeField.onClick'}"
				selectedItem="@{controller.selectionModel.selectedAuthorContact, save-when='self.onSelect', load-after='ticketAuthorTypeField.onClick'}"
				disabled="@{controller.ticketAuthorContactDisabled, load-after='ticketAuthorTypeField.onClick'}">
				<comboitem self="@{each=contact}" label="@{contact}" />
			</combobox>

		</radiogroup>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-radio:eq(1)").toWidget().$n("real"))
      waitResponse()
      
      verifyTrue("the combobox should be enable", !jq(".z-combobox-disabled").exists)
    })
    
  }
}