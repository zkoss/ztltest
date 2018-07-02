/* B36_2813877Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2813877Test extends ZTL4ScalaTestCase {
  @Test
  def testresizer() = {
    var zscript =
      """
			<zk>
				<window id="win" border="normal" width="350px" minheight="350">
					<caption
						image="/img/Centigrade-Widget-Icons/FirstWindow-24x24.png"
						label="Complex Window" />
					<borderlayout height="300px">
						<north border="none">
							<menubar id="menubar" width="100%">
								<menu label="Project"
									src="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
									<menupopup>
										<menuitem
											src="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
											label="New" onClick="alert(self.label)" />
										<menuitem
											src="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
											label="Open" onClick="alert(self.label)" />
										<menuitem
											src="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
											label="Save" onClick="alert(self.label)" />
										<menuseparator />
										<menuitem label="Exit"
											src="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
											onClick="alert(self.label)" />
									</menupopup>
								</menu>
								<menu label="Help"
									src="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
									<menupopup>
										<menuitem label="Index"
											onClick="alert(self.label)" />
										<menu label="About">
											<menupopup>
												<menuitem label="About ZK"
													onClick="alert(self.label)" />
												<menuitem label="About Potix"
													onClick="alert(self.label)" />
											</menupopup>
										</menu>
									</menupopup>
								</menu>
								<menu
									src="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
									<menupopup>
										<menuitem label="Index"
											onClick="alert(self.label)" />
									</menupopup>
								</menu>
							</menubar>
						</north>
						<center>
							<div>
								Auto-position (applicable if not embedded)
								<image src="/img/earth.png" />
							</div>
						</center>
						<south border="0">
							<toolbar mold="panel" align="center">
								<button label="left,center"
									onClick="win.position = &quot;left,center&quot;;" />
								<button label="right,bottom"
									onClick="win.position = &quot;right,bottom&quot;;" />
								<button label="center"
									onClick="win.position = &quot;center&quot;;" />
							</toolbar>
						</south>
					</borderlayout>
				</window>
				<button label="Overlap"
					onClick="win.setSizable(true);win.doOverlapped();" />
				<button label="Popup" onClick="win.setSizable(true);win.doPopup();" />
				<button label="Embed"
					onClick="win.setSizable(false);win.doEmbedded();" />
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val menubar = ztl$engine.$f("menubar")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Overlap\"]"))
      waitResponse()
      dragdropTo(jq("$win"), "341,292", "619,298")
      waitResponse()
      dragdropTo(jq("@caption"), "174,19", "176,66")
      waitResponse()
      click(jq("@button[label=\"Embed\"]"))
      waitResponse()
      click(jq("@button[label=\"Popup\"]"))
      waitResponse()
      dragdropTo(jq("$win").toWidget().$n("cave"), "349,222", "654,218")
      waitResponse()
    })
  }
}



