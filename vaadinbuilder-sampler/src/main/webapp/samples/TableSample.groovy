hlayout {
    table (header:['first', 'second']){
        (0..5).each { idx ->
            tr {
                label(value: "this is a test$idx")
                button(caption: 'to be clicked')
            }

        }
    }
    table (header:['first', 'second', 'third'], values:[
            ['one', 2, true],
            ['one', 2, true],
            ['one', 2, true],
            ['one', 2, true],
    ])

}