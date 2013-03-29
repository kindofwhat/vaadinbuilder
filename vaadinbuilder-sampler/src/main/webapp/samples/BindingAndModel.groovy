vlayout() {
    textfield('text', caption: 'Enter text and click away', model: 'text', immediate: true)
    textfield(caption: 'Changed text here', propertyRef: 'text', readOnly: true)
}
