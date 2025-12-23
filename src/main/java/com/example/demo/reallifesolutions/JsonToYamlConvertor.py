import json
import yaml

# --------------------------------
# 1️⃣ Normal JSON → YAML
# --------------------------------
def convert_yaml_from_json(data):
    """
    Equivalent to:
    YAMLMapper.writeValueAsString(data)
    """
    return yaml.dump(
        data,
        default_flow_style=False,
        sort_keys=False
    )


# --------------------------------
# 2️⃣ Schema-style YAML converter
# --------------------------------
def convert_to_schema_yaml(json_data):
    yaml_lines = []
    build_schema_yaml(json_data, yaml_lines, 0, None)
    return "\n".join(yaml_lines)


def build_schema_yaml(node, yaml_lines, indent, key):
    space = "  " * indent

    if key is not None:
        yaml_lines.append(f"{space}{key}:")

    if isinstance(node, dict):
        if key is not None:
            yaml_lines.append(f"{space}  type: object")
            yaml_lines.append(f"{space}  properties:")
        for k, v in node.items():
            build_schema_yaml(v, yaml_lines, indent + (0 if key is None else 2), k)

    elif isinstance(node, list):
        yaml_lines.append(f"{space}  type: array")
        yaml_lines.append(f"{space}  items:")
        if node:
            build_schema_yaml(node[0], yaml_lines, indent + 2, None)

    else:
        yaml_lines.append(f"{space}  type: {get_type(node)}")
        yaml_lines.append(f"{space}  example: {format_example(node)}")


def get_type(value):
    if isinstance(value, str):
        return "string"
    if isinstance(value, bool):
        return "boolean"
    if isinstance(value, int):
        return "integer"
    if isinstance(value, float):
        return "number"
    return "string"


def format_example(value):
    if isinstance(value, str):
        return f"\"{value}\""
    return value


# --------------------------------
# 3️⃣ Run as script
# --------------------------------
if __name__ == "__main__":

    # 🔹 Option A: Read from file
    with open(
    "src/main/java/com/example/demo/reallifesolutions/input.json",
    "r",
    encoding="utf-8"
) as f:json_data = json.load(f)


    # 🔹 Normal YAML
    normal_yaml = convert_yaml_from_json(json_data)
    print("==== Normal YAML ====")
    print(normal_yaml)

    # 🔹 Schema-style YAML
    schema_yaml = convert_to_schema_yaml(json_data)
    print("==== Schema YAML ====")
    print(schema_yaml)

    # 🔹 Optional: write to files
    with open("output.yaml", "w", encoding="utf-8") as f:
        f.write(normal_yaml)

    with open("schema_output.yaml", "w", encoding="utf-8") as f:
        f.write(schema_yaml)
