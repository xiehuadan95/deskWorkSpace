"use strict";
module.exports = {
    "port":8084,
    "browser" : ["chrome"],
    "server": {
        middleware: {
            // overrides the second middleware default with new settings
            1: require('connect-history-api-fallback')({
                index: '/index.html',
                verbose: true,
            }),
        },
    },
};