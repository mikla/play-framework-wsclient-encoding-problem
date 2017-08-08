Minimal project to reproduce `Play Framework` `WSClient` problem with `application/json` responses.

I'm using `WSClient` to send request to "self" (`localhost:9000/utf8response`) to get UTF-8 string.

`curl --verbose 'localhost:9000/utf8response'` - returns `json` with correct encoding.
```json
{"name":"āčēģīķļņšūž ĀČĒĢĪĶĻŅŠŪŽ"}%
```

`curl --verbose 'localhost:9000/requestEmployee'` (calls `/utf8response` via `WSClient`) - returns `json` with corrupted encoding.
```json
{"name":"ÄÄÄÄ£Ä«Ä·Ä¼ÅÅ¡Å«Å¾ ÄÄÄÄ¢ÄªÄ¶Ä»ÅÅ ÅªÅ½"}%
```

Workaround:

Replace `JSON` to `text/json; charset=utf-8`.
