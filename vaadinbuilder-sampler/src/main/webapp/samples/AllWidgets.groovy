tabsheet(caption: 'All Components') {
    hlayout(caption: 'Simple Components', spacing: true) {
        label(caption: 'Label')
        link(caption: 'Link (to Vaadin)', href:'http://vaadin.com')

    }
    gridlayout(columns:3, caption: 'Text Fields', spacing: true) {
        textfield(caption: 'Text Field')
        textArea(caption: 'Text Area')
        password(caption: 'Pasword')
        richtext(caption: 'Richtext')
        datefield(caption: 'Datefield')
        popupdatefield(caption: 'PopupDateField ')

    }
    gridlayout(columns:3, caption: 'Buttons and Select', spacing: true) {
        button(caption:'Button')
        linkbutton(caption:'LinkButton', href:'http://vaadin.com')
        combobox(caption: 'ComboBox', values:["one", "two", "threeyea"])
    }
    hlayout(caption: 'Tables', spacing: true) {
        vlayout() {
            table (caption: ' Sample with Components and tr', header:['first', 'second']){
                (0..5).each { idx ->
                    tr {
                        label(value: "this is a test$idx")
                        button(caption: 'to be clicked')
                    }

                }
            }

        }
        vlayout()      {
            table (caption: ' Sample with values argument',header:['first', 'second', 'third'], values:[
                    ['one', 1, true],
                    ['two', 11, true],
                    ['three', 111, true],
                    ['four', 1111, true],
            ])
        }
    }
}

