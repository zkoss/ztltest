import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-707-ListModelTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-707-ListModelTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			    <zscript><![CDATA[
			String[] data = new String[10];
			for (int i = 0; i < data.length; i++)
				data[i] = "option_" + i;
			
			
			ListModelList model = new ListModelList(data);
			    ]]></zscript>
			    1. Please test to select the listitem, the both listbox should be the same result. (test both checked/unchecked multiple)
			    <checkbox id="cbx" label="Multiple Selections">
			    	<attribute name="onCheck">
			    	model.setMultiple(event.checked);
			    	
			    	// reset model
			    	gridOne.setModel(null);
			    	gridTwo.setModel(null);
			    	gridOne.setModel(model);
			    	gridTwo.setModel(model);
			    	</attribute>
			    </checkbox>
			    <separator/>
			    2. Please click upon the head "Column" to sort it, the selection status and sorting
			    function also affect the both listbox.
			    <listbox id="gridOne" model="\${model}" checkmark="true" onSelect="">
			    	<listhead><listheader label="column" sort="auto"/></listhead>
			    </listbox>
			    
			    <listbox id="gridTwo" model="\${model}" checkmark="true" onSelect="">
			    	<listhead><listheader label="column" sort="auto"/></listhead>
			    </listbox>
			</zk>`,
	);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_1)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2 && verifyVariable_cafe_3_3)
		.ok("Both first grid and second grid select the option_1");
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_3)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_3)",
			)[0],
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_3)",
			)[0],
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_3)",
			)[0],
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_3)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2t && verifyVariable_cafe_3_3t)
		.ok("Both first grid and second grid select the option_3");
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_2)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2tt && verifyVariable_cafe_3_3tt)
		.ok("Both first grid and second grid select the option_2");
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_1)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_5)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listitem:contains(option_4)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_1)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2ttt && verifyVariable_cafe_3_3ttt)
		.ok("Both first grid and second grid select the option_1");
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_2_2tttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_2)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2tttt && verifyVariable_cafe_3_3tttt)
		.ok("Both first grid and second grid select the option_2");
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_4)",
			)[0],
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_4)",
			)[0],
	)();
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_4)",
			)[0],
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_4)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2ttttt && verifyVariable_cafe_3_3ttttt)
		.ok("Both first grid and second grid select the option_4");
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_5)",
			)[0],
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_5)",
			)[0],
	)();
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
				".z-listitem-selected:contains(option_5)",
			)[0],
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
				".z-listitem-selected:contains(option_5)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_2_2tttttt && verifyVariable_cafe_3_3tttttt)
		.ok("Both first grid and second grid select the option_5");
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listheader:contains(column)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
					".z-listheader:contains(column)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_9"),
			"The item 0 of first/second grid should containsoption_9",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_9"),
			"The item 0 of first/second grid should containsoption_9",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[1].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_8"),
			"The item 1 of first/second grid should containsoption_8",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[1].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_8"),
			"The item 1 of first/second grid should containsoption_8",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[2].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_7"),
			"The item 2 of first/second grid should containsoption_7",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[2].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_7"),
			"The item 2 of first/second grid should containsoption_7",
		);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
					".z-listheader:contains(column)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_0"),
			"The item 0 of first/second grid should containsoption_0",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_0"),
			"The item 0 of first/second grid should containsoption_0",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[1].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_1"),
			"The item 1 of first/second grid should containsoption_1",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[1].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_1"),
			"The item 1 of first/second grid should containsoption_1",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridOne", true).$n()).find(
							".z-listitem",
						)[2].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_2"),
			"The item 2 of first/second grid should containsoption_2",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("gridTwo", true).$n()).find(
							".z-listitem",
						)[2].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option_2"),
			"The item 2 of first/second grid should containsoption_2",
		);
});
