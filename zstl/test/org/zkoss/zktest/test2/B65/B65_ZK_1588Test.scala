package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1588.zul")
class B65_ZK_1588Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<div height="100%">
		<div height="90%">
			when click the button of bandbox, the popup should be above bandbox.
		</div>
		<div height="10%">
			<bandbox id="bd" mold="rounded" xmlns:w="client">
				<bandpopup>
					<vbox>
						<hbox>
							Search
							<textbox />
						</hbox>
						<listbox width="200px"
							onSelect="bd.value=self.selectedItem.label; bd.close();">
							<listhead>
								<listheader label="Name" />
								<listheader label="Description" />
							</listhead>
							<listitem>
								<listcell label="John" />
								<listcell label="CEO" />
							</listitem>
							<listitem>
								<listcell label="Joe" />
								<listcell label="Engineer" />
							</listitem>
							<listitem>
								<listcell label="Mary" />
								<listcell label="Supervisor" />
							</listitem>
							<listitem>
								<listcell label="John" />
								<listcell label="CEO" />
							</listitem>
							<listitem>
								<listcell label="Joe" />
								<listcell label="Engineer" />
							</listitem>
							<listitem>
								<listcell label="Mary" />
								<listcell label="Supervisor" />
							</listitem>
							<listitem>
								<listcell label="John" />
								<listcell label="CEO" />
							</listitem>
							<listitem>
								<listcell label="Joe" />
								<listcell label="Engineer" />
							</listitem>
							<listitem>
								<listcell label="Mary" />
								<listcell label="Supervisor" />
							</listitem>
						</listbox>
					</vbox>
				</bandpopup>
			</bandbox>
		</div>
	</div>
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-bandbox").toWidget().$n("btn"))
        waitResponse()

        val pp = jq(jq(".z-bandbox").toWidget().$n("pp"))
        verifyTrue("when click the button of bandbox, the popup should be above bandbox.", (pp.offsetTop() + pp.height()) <= jq(jq(".z-bandbox").toWidget().$n("real")).offsetTop())
      })

  }
}
