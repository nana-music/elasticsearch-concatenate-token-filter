# Elasticsearch Concatenate Token Filter

Elasticsearch plugin which only provides a Token Filter that merges tokens in a token stream back into one. Taken from http://elasticsearch-users.115913.n3.nabble.com/Is-there-a-concatenation-filter-td3711094.html

## Installation

    bin/plugin install concatenate --url https://github.com/nana-music/elasticsearch-concatenate-token-filter/releases/download/v0.0.1/elasticsearch-concatenate-0.0.1.zip

## Version

| Concatenate Token Filter | Elasticsearch |
|:-------|:-------|
| 0.0.1  | 1.3.2  |

## Usage

The plugin provides a token filter of type `concatenate` which has one parameter `token_separator`. Use it in your custom analyzers to merge tokenized strings back into one single token (usually after applying stemming or other token filters).

### Arrays

When saving arrays of strings to a field, these are handled in elasticsearch as separate tokens, so this filter would collapse all the elements of the array into one, and usually you don't want that to happen. As a workaround you can set `position_offset_gap` on the field to a high number and pass the same number as the `increment_gap` parameter to the filter, which then only concatenates all tokens closer than this value.

## Example

```javascript
{
  "analysis" : {
    "filter" : {
      "concatenate" : {
        "type" : "concatenate",
        "token_separator" : "_"
      },
      "custom_stop" : {
        "type": "stop",
        "stopwords": ["and", "is", "the"]
      }
    },
    "analyzer" : {
      "stop_concatenate" : {
        "filter" : [
          "custom_stop",
          "concatenate"
        ],
        "tokenizer" : "standard"
      }
    }
  }
}
```

the string

    "the fox jumped over the fence"
    
would be analyzed as

    "fox_jumped_over_fence"
