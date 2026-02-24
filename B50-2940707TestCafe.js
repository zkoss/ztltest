import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2940707TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2940707TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
			    <html>
			        <![CDATA[
			            <ol>
			<li>Press button 1. You shall see the layout nothing changed.</li>
			<li>Press button 2. You shall see the layout nothing changed again.</li>
			<li>Press button 3. You shall see Item 2.2.1 removed and the "triangle" icon before Item 2.2
			removed.</li>
			<li>Reload this test case.</li>
			<li>Press button 4. You shall see Item 2.2.1 removed and the "triangle"
			icon before Item 2.2. removed.</li>
			<li>Select 2.1, 2.1.1 and 2.1.2</li>
			<li>Press button 2. You shall see the selection remains the same, i.e., all these three items being selected</li>
			<li>Unselect 2.1.1</li>
			<li>Press button 2 again. You shall see selection remains the same, i.e., 2.1 and 2.1.2 are both selected</li> 
			<li>Otherwise, it is a bug!</li>
			</ol>
			        ]]>
			    </html>
			    <tree id="tree" width="400px" rows="8" checkmark="true" multiple="true">
			        <treecols sizable="true">
			            <treecol label="Name" />
			            <treecol label="Description" />
			        </treecols>
			        <treechildren>
			            <treeitem>
			                <treerow>
			                    <treecell label="Item 1" />
			                    <treecell label="Item 1 description" />
			                </treerow>
			            </treeitem>
			            <treeitem>
			                <treerow>
			                    <treecell label="Item 2" />
			                    <treecell label="Item 2 description" />
			                </treerow>
			                <treechildren>
			                    <treeitem>
			                        <treerow>
			                            <treecell label="Item 2.1" />
			                        </treerow>
			                        <treechildren>
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.1.1" />
			                                </treerow>
			                            </treeitem>
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.1.2" />
			                                </treerow>
			                            </treeitem>
			                        </treechildren>
			                    </treeitem>
			                    <treeitem id="item221parent">
			                        <treerow>
			                            <treecell label="Item 2.2" />
			                        </treerow>
			                        <treechildren id="item221">
			                            <treeitem>
			                                <treerow>
			                                    <treecell label="Item 2.2.1" />
			                                </treerow>
			                            </treeitem>
			                        </treechildren>
			                    </treeitem>
			                </treechildren>
			            </treeitem>
			            <treeitem label="Item 3" />
			        </treechildren>
			    </tree>
			   <button id="btn1" label="1. invalidate item 2.2"
			onClick="item221parent.invalidate();"/>
			    <button id="btn2" label="2. invalidate item 2.1 and item 2.2"
			onClick="item221parent.parent.invalidate();"/>
			    <button id="btn3" label="3. detach item 2.2.1" onClick="item221.detach();"/>
			    <button id="btn4" label="4. detach item 2.2.1 and invalidate item 2.2"
			onClick="item221.detach();item221parent.invalidate();"/>
				</vbox>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-treechildren tr.z-treerow").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("8"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-treechildren tr.z-treerow").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treechildren tr.z-treerow:eq(6)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 2.2.1"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-treechildren tr.z-treerow").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treechildren tr.z-treerow:eq(6)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 3"), "");
});
