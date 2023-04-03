module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
    "./src/**/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      maxHeight: {
        '550px': '550px',
      },
      zIndex: {
        '-1': '-1',
      }
    },
    namedGroups: ["foo", "bar", "btn3b", "group-hover"],

  },
  plugins: [require("tailwindcss-named-groups"),
  ],
  variants: {
    // Now you can use named groups in textColor for hover and focus
    textColor: ["responsive", "hover", "focus", "group-hover", "group-focus"],
  },
}
