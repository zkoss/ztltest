package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Listbox_1_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<listbox rows="1" mold="select">
		<listitem label="Inbox"/>
		<listitem label="Received"/>
		<listitem label="Draft"/>
	</listbox>
	<separator bar="true"/>
	<listbox fixedLayout="true">
		<listhead sizable="true">
			<listheader align="center" width="40px"
				image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
			<listheader align="center" width="40px" image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
			<listheader align="center" width="40px"
				image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
			<listheader label="Subject" sort="auto"/>
			<listheader label="Received" sort="auto"/>
		</listhead>
		<listitem height="28px">
			<listcell image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
			<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
			<listcell image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
			<listcell label="ZK Jet 0.8.0 is released" />
			<listcell label="2008/11/17 17:41:29" />
		</listitem>
		<listitem height="28px">
			<listcell image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
			<listcell image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
			<listcell image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
			<listcell label="URLs for iPhone-Optimized Google Sites" />
			<listcell label="2008/11/17 15:56:37" />
		</listitem>
		<listitem height="28px">
			<listcell label="&#160;" />
			<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
			<listcell label="&#160;" />
			<listcell label="Style Guide for ZK 3.5 released" />
			<listcell label="2008/11/14 13:23:07" />
		</listitem>
		<listitem height="28px">
			<listcell image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
			<listcell image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
			<listcell label="&#160;" />
			<listcell label="ZK Studio 0.9.0 released." />
			<listcell label="2008/11/16 10:26:37" />
		</listitem>
	</listbox>
	<separator/>
	Listbox Live data
	<zscript>
		public class FakeListModel extends AbstractListModel {
			private int _size;

			public FakeListModel() {
				this(10000);
			}
				
			public FakeListModel(int size) {
				_size = size;
			}

			public void invalidate() {
				fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
			}

			// AbstractListModel
			public Object getElementAt(int v) {
				String value = "Option " + v;
				return value;
			}
	
			// AbstractListModel
			public int getSize() {
				return _size;
			}
	
			// AbstractListModel
			public void setSize(int size) {
				_size = size;
			}
			
			protected void fireSelectionEvent(Object e) {
				if (e instanceof String) {
					String s = ((String) e).replace("Option ", "");
					fireEvent(ListDataEvent.SELECTION_CHANGED, Integer.parseInt(s), -1);
				} else
					super.fireSelectionEvent(e);
			}
		}

		ListModel strset = new FakeListModel(200);
	</zscript>
	<listbox id="list" width="200px" rows="5" model="${strset}">
		<listhead>
			<listheader label="Load on Demend" sort="auto"/>
		</listhead>
	</listbox>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}